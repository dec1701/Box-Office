package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;

/**
 * This route is taken when the customer submits their information for an exchange.
 * Its purpose is to perform the actual exchange within the model.
 */
public class PostSwapRoute implements Route {
	// Controller class - responsible for managing information btwn Model and View
	private Sales sales;

	/**
	 * Constructor - creates a new instance of PostSwapRoute
	 * @param sales - the Controller class for communicating w/ the model
	 */
	public PostSwapRoute(Sales sales){
		this.sales = sales;
	}

	/**
	 * Performs this route's operations:
	 *      Update the screens' sales & available tickets
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		if(request.queryParams("numTix") != null && request.queryParams("returnScreen") != null
			&& request.queryParams("screenNum") != null) {

			// getting the amount of tickets being exchanged & for what screens
			int numTix = Integer.parseInt(request.queryParams("numTix"));
			int returnScreen = Integer.parseInt(request.queryParams("returnScreen"));
			int screenNum = Integer.parseInt(request.queryParams("screenNum"));

			// tell the Controller that the Model needs to update
			int success = sales.makeExchange(screenNum, returnScreen, numTix);

			// put the return value in the user's session so other routes can
			// access it
			Session httpSession = request.session();
			httpSession.attribute("success", success);

			response.redirect("/swap");
		}
		return null;
	}
}
