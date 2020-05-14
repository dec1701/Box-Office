package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;

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

	private TemplateEngine templateEngine;

	/**
	 * Constructor - creates a new instance of GetPurchaseRoute
	 * @param sales - the Controller class, used to communicate
	 *              with the Model
	 */
	public GetPurchaseRoute(Sales sales, TemplateEngine templateEngine){
		this.sales = sales;
		this.templateEngine = templateEngine;
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public Object handle(Request request, Response response){
		// getting the number of the screen for which tickets are being bought
		Session httpSession = request.session();
		Map<String, Object> model = new HashMap<>();

		if(httpSession.attribute("purchasing").equals(1)){
			httpSession.attribute("purchasing", 0);
			httpSession.attribute("purchaseComplete", 1);

			return templateEngine.render(new ModelAndView(model, "purchase.ftl"));
		}
		else if(httpSession.attribute("purchaseComplete").equals(1)){
			httpSession.attribute("purchaseComplete", 0);

			model.put("complete", 1);
			return templateEngine.render(new ModelAndView(model, "purchase.ftl"));
		}

		httpSession.attribute("purchasing", 1);
		response.redirect("/purchase");
		return null;
	}
}
