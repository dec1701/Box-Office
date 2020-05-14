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

	private TemplateEngine templateEngine;
	private Sales sales;

	public GetReportRoute(TemplateEngine templateEngine, Sales sales){

		this.templateEngine = templateEngine;
		this.sales = sales;
	}

	@Override
	public Object handle(Request request, Response response){
		Session httpSession = request.session();
		Map<String, Object> model = new HashMap<>();

		if(httpSession.attribute("reporting").equals(1)){
			httpSession.attribute("reporting", 0);
			httpSession.attribute("reportComplete", 1);
			return templateEngine.render(new ModelAndView(model, "report.ftl"));
		}
		else if(httpSession.attribute("reportComplete").equals(1)){

			httpSession.attribute("reportComplete", 0);

			model.put("print", 1);

			int screenNum = httpSession.attribute("screenNum");

			httpSession.removeAttribute("screenNum");

			if(screenNum == -1){
				model.put("report", sales.report());
			}
			else{
				model.put("report", sales.report(screenNum));
			}

			return templateEngine.render(new ModelAndView(model, "report.ftl"));
		}

		httpSession.attribute("reporting", 1);
		response.redirect("/report");
		return null;
	}
}
