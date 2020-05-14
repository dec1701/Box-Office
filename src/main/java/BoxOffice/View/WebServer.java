package BoxOffice.View;

import static spark.Spark.*;
import BoxOffice.Controller.Sales;
import spark.TemplateEngine;

public class WebServer {

	// URLs for each page
	private static final String HOME_URL = "/";
	private static final String PURCHASE_URL = "/purchase";
	private static final String CONFIRM_PURCHASE_URL = "/confirm";
	private static final String CHOOSE_REPORT_URL = "/report";
	private static final String PRINT_REPORT_URL = "/report/print";

	private TemplateEngine templateEngine;
	private Sales sales;

	public WebServer(final TemplateEngine templateEngine, Sales sales){
		this.templateEngine = templateEngine;
		this.sales = sales;
	}

	public void initRoutes(){

		staticFileLocation("/public");

		get(HOME_URL, new GetHomeRoute(templateEngine));
		post(CONFIRM_PURCHASE_URL, new PostPurchaseRoute(templateEngine, sales));
		get(PURCHASE_URL, new GetPurchaseRoute(sales, templateEngine));
		post(CHOOSE_REPORT_URL, new PostReportRoute(templateEngine));
		get(PRINT_REPORT_URL, new GetReportRoute(sales, templateEngine));

		System.out.println("WebServer is up");
	}
}
