package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken after the user has specified what screen(s) they
 * want reports for. Its purpose is to collect and display the necessary
 * information from the Model
 */
public class GetReportRoute implements Route {

	private Sales sales;

	private TemplateEngine templateEngine;

	public GetReportRoute(Sales sales, TemplateEngine templateEngine){
		this.sales = sales;
		this.templateEngine = templateEngine;
	}

	@Override
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

		return templateEngine.render(new ModelAndView(model, "report.ftl"));
	}
}
