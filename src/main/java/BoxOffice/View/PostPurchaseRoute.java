package BoxOffice.View;

import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken when the user has to give information about their
 * purchase (what screen, how mnay tickets). Its purpose is to collect
 * the information from the user and store it in the session so it can
 * be used in other routes.
 */
public class PostPurchaseRoute implements Route {

	public PostPurchaseRoute(){

	}

	public Object handle(Request request, Response response){
		Session httpSession = request.session();
		httpSession.attribute("screenNum", request.queryParams("screenNum"));

		Map<String, Object> model = new HashMap<>();

		return new FreeMarkerEngine().render(
				new ModelAndView(model, "purchase.ftl"));
	}
}
