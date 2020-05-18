package BoxOffice.View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken upon initial connection to the server.
 * Its purpose is to allow the user to select what functionality
 * they are looking for.
 */
public class GetHomeRoute implements Route {

	// Freemarker Template Engine - fills in and render a .ftl file
	private final TemplateEngine templateEngine;

	/**
	 * Constructor - creates a new instance of GetHomeRoute
	 * @param templateEngine - the template engine used to render .ftl files
	 */
	public GetHomeRoute(TemplateEngine templateEngine){
		this.templateEngine = templateEngine;
	}

	/**
	 * Performs this route's operations:
	 *      Prepares the session's attributes
	 *      Displays the home page
	 * @param request - a Spark request, contains the user's session
	 *                as well as any query parameters
	 * @param response - a Spark response
	 * @return the result of the Template Engine's render
	 */
	@Override
	public Object handle(Request request, Response response){

		// Get the user's session
		Session httpSession = request.session();

		// Prepare session attributes to prevent null values
		httpSession.attribute("purchasing", 0);
		httpSession.attribute("purchaseComplete", 0);

		httpSession.attribute("reporting", 0);
		httpSession.attribute("reportComplete", 0);

		httpSession.attribute("swapping", 0);
		httpSession.attribute("swapComplete", 0);

		// The map of values to fill in to the .ftl file
		Map<String, Object> model = new HashMap<>();

		return templateEngine.render(new ModelAndView(model, "home.ftl"));
	}
}
