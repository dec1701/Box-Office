package BoxOffice.View;

import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken when the user must provide information about the
 * report that they want (the number of the screen). Its purpose is to
 * collect that information from the user and store it in the session
 * so that other routes can access it.
 */
public class PostReportRoute implements Route {

	public PostReportRoute(){

	}

	public Object handle(Request request, Response response){
		Session httpSession = request.session();
		httpSession.attribute("screenNum", request.queryParams("screenNum"));

		Map<String, Object> model = new HashMap<>();

		return new FreeMarkerEngine().render(
				new ModelAndView(model, "reoprt.ftl"));
	}
}
