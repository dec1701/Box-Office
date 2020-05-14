package BoxOffice.View;

import BoxOffice.Controller.Sales;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * This route is taken when the user has to give information about their
 * purchase (what screen, how mnay tickets). Its purpose is to collect
 * the information from the user and store it in the session so it can
 * be used in other routes.
 */
public class PostPurchaseRoute implements Route {

	private TemplateEngine templateEngine;
	private Sales sales;

	public PostPurchaseRoute(TemplateEngine templateEngine, Sales sales){
		this.templateEngine = templateEngine;
	}

	@Override
	public Object handle(Request request, Response response){
		int numTix = Integer.parseInt(request.queryParams("numTix"));
		int screenNum = Integer.parseInt(request.queryParams("screenNum"));

		sales.makePurchase(screenNum, numTix);

		response.redirect("/purchase");
		return null;
	}
}
