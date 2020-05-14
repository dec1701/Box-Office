package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken after a customer selects the number of tickets
 * they want and the screen they are purchasing for. Its purpose is
 * to communicate to the Controller level the purchase that is being
 * made.
 */
public class GetPurchaseRoute implements Route {

	// Controller class - will tell Model to update
	private Sales sales;

	/**
	 * Constructor - creates a new instance of GetPurchaseRoute
	 * @param sales - the Controller class, used to communicate
	 *              with the Model
	 */
	public GetPurchaseRoute(Sales sales){
		this.sales = sales;
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public Object handle(Request request, Response response){
		// getting the number of the screen for which tickets are being bought
		Session httpSession = request.session();
		int screenNum = httpSession.attribute("screenNum");
		httpSession.removeAttribute("screenNum");

		// getting the number of tickets being bought
		int numTix = httpSession.attribute("numTix");
		httpSession.removeAttribute("numTix");

		sales.makePurchase(screenNum, numTix);

		Map<String, Object> model = new HashMap<>();
		model.put("complete", 1);

		return new FreeMarkerEngine().render(
				new ModelAndView(model, "purchase.ftl"));
	}
}
