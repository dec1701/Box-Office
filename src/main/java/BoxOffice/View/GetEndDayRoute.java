package BoxOffice.View;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.stop;

/**
 * This route is taken after the sales report for the day is displayed.
 * Its purpose is the shut down the server.
 */
public class GetEndDayRoute implements Route {

	/**
	 * Constructor - creates a new instance of the GetEndDayRoute
	 */
	public GetEndDayRoute(){}

	/**
	 * Performs this route's operations:
	 *      Shuts down the server
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		stop();
		return null;
	}
}
