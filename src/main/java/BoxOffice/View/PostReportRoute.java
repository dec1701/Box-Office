package BoxOffice.View;

import spark.*;

/**
 * This route is taken when the user must provide information about the
 * report that they want (the number of the screen). Its purpose is to
 * collect that information from the user and store it in the session
 * so that other routes can access it.
 */
public class PostReportRoute implements Route {
	/**
	 * Constructor - creates a new instance of PostReportRoute
	 */
	public PostReportRoute(){ }

	/**
	 * Performs this route's operations:
	 *      Retrieve the number of the screen the user wants a report on
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		// getting the number of the screen that the user wants a report on
		int screenNum = Integer.parseInt(request.queryParams("screenNum"));

		// putting that number in the user's session so other routes can access it
		Session httpSession = request.session();
		httpSession.attribute("screenNum", screenNum);

		response.redirect("/report");
		return null;
	}
}
