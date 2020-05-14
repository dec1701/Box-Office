package BoxOffice.View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken when the user must provide information about the
 * report that they want (the number of the screen). Its purpose is to
 * collect that information from the user and store it in the session
 * so that other routes can access it.
 */
public class PostReportRoute implements Route {

	private TemplateEngine templateEngine;

	public PostReportRoute(TemplateEngine templateEngine){
		this.templateEngine = templateEngine;
	}

	@Override
	public Object handle(Request request, Response response){
		int screenNum = Integer.parseInt(request.queryParams("screenNum"));

		Session httpSession = request.session();
		httpSession.attribute("screenNum", screenNum);

		response.redirect("/report");
		return null;
	}
}
