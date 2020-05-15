package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;

/**
 * This route is taken when the user has to give information about their
 * purchase (what screen, how mnay tickets). Its purpose is to collect
 * the information from the user and store it in the session so it can
 * be used in other routes.
 */
public class PostPurchaseRoute implements Route {
	// Controller class - responsible for managing information btwn Model and View
	private Sales sales;

	/**
	 * Constructor - creates a new instance of PostPurchaseRoute
	 * @param sales - the Controller class for communicating w/ the model
	 */
	public PostPurchaseRoute(Sales sales){
		this.sales = sales;
	}

	/**
	 * Performs this route's operations:
	 *      Update the screen's sales & available tickets
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		// getting the amount of tickets being purchased & for what screen
		int numTix = Integer.parseInt(request.queryParams("numTix"));
		int screenNum = Integer.parseInt(request.queryParams("screenNum"));

		// tell the Controller that the Model needs to update
		int success = sales.makePurchase(screenNum, numTix);

		// put the return value in the user's session so other routes can
		// access it
		Session httpSession = request.session();
		httpSession.attribute("success", success);

		response.redirect("/purchase");
		return null;
	}
}
