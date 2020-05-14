package BoxOffice.View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken upon initial connection to the server.
 * Its purpose is to
 */
public class GetHomeRoute implements Route {

	private final TemplateEngine templateEngine;

	public GetHomeRoute(TemplateEngine templateEngine){
		this.templateEngine = templateEngine;
	}

	@Override
	public Object handle(Request request, Response response){

		Session httpSession = request.session();

		httpSession.attribute("purchasing", 0);
		httpSession.attribute("purchaseComplete", 0);

		httpSession.attribute("reporting", 0);
		httpSession.attribute("reportComplete", 0);

		Map<String, Object> model = new HashMap<>();

		return templateEngine.render(new ModelAndView(model, "home.ftl"));
	}
}
