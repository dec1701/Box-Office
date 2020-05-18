package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken when a customer is trying to perform an exchange.
 * Its purpose is to handle the rendering of the exchange/swap page.
 */
public class GetSwapRoute implements Route {

	// Freemarker Template Engine - fills in and render a .ftl file
	private TemplateEngine templateEngine;

	// Controller class - responsible for managing information btwn Model and View
	private Sales sales;

	/**
	 * Constructor - creates a new instance of GetSwapRoute
	 * @param templateEngine - the template engine used to render .ftl files
	 * @param sales - the Controller class for communicating with the model
	 */
	public GetSwapRoute(TemplateEngine templateEngine, Sales sales){

		this.templateEngine = templateEngine;
		this.sales = sales;

	}

	/**
	 * Performs this route's operations:
	 *
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response, used for redirecting
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){
		// Getting the user's session
		Session httpSession = request.session();

		// The map of values to fill in to the .ftl file
		Map<String, Object> model = new HashMap<>();

		// If the user needs to provide info for the swap
		if(httpSession.attribute("swapping").equals(1)){

			// reset this session value so it will not trigger on this route again
			httpSession.attribute("swapping", 0);

			// set this session value so it will trigger when the user comes
			// back to this route
			httpSession.attribute("swapComplete", 1);

			// Store all the required values in the map so they can be rendered
			model.put("s0Remain", sales.getRemaining(0));
			model.put("s1Remain", sales.getRemaining(1));
			model.put("s2Remain", sales.getRemaining(2));
			model.put("s3Remain", sales.getRemaining(3));
			model.put("s4Remain", sales.getRemaining(4));

			return templateEngine.render(new ModelAndView(model, "swap.ftl"));
		}
		// If the user has provided info for the purchase
		else if(httpSession.attribute("swapComplete").equals(1)){
			// reset this session value so it will not trigger on this route again
			httpSession.attribute("purchaseComplete", 0);

			// lets the .ftl file know which html to display
			model.put("complete", 1);

			int success = httpSession.attribute("success");
			if(success == 1){
				model.put("success", 1);
			}
			else if(success == 0){
				model.put("purchaseFail", 1);
			}
			else{
				model.put("returnFail", 1);
			}

			return templateEngine.render(new ModelAndView(model, "swap.ftl"));
		}

		// set this session value so it will trigger when the user comes
		// back to this route
		httpSession.attribute("swapping", 1);
		response.redirect("/swap");
		return null;
	}
}
