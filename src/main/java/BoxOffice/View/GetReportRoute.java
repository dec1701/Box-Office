package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken after the user has specified what screen(s) they
 * want reports for. Its purpose is to collect and display the necessary
 * information from the Model
 */
public class GetReportRoute implements Route {

	private Sales sales;

	public GetReportRoute(Sales sales){
		this.sales = sales;
	}

	public Object handle(Request request, Response response){
		Session httpSession = request.session();
		int screenNum = httpSession.attribute("screenNum");

		String report;

		// a screen number of -1 represents that the report should contain
		// all screens
		if(screenNum > -1){
			report = sales.report(screenNum);
		}
		else{
			report = sales.report();
		}

		response.body(report);

		Map<String, Object> model = new HashMap<>();
		model.put("print", 1);
		model.put("report", report);

		return new FreeMarkerEngine().render(
				new ModelAndView(model, "report.ftl"));
	}
}
