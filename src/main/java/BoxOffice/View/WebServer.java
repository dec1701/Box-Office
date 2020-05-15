package BoxOffice.View;

import static spark.Spark.*;
import BoxOffice.Controller.Sales;
import spark.TemplateEngine;

public class WebServer {

	// URLs for each page
	private static final String HOME_URL = "/";
	private static final String PURCHASE_URL = "/purchase";
	private static final String CONFIRM_PURCHASE_URL = "/confirm";
	private static final String REPORT_URL = "/report";
	private static final String PRINT_REPORT_URL = "/report/print";
	private static final String END_DAY_URL = "/end";

	// Freemarker Template Engine - fills in and render a .
	private TemplateEngine templateEngine;

	// Controller class - responsible for managing information btwn Model and View
	private Sales sales;

	/**
	 * Constructor - creates a new instance of WebServer
	 * @param templateEngine - the template engine used to render .ftl files
	 * @param sales - the Controller class for communicating w/ the model
	 */
	public WebServer(final TemplateEngine templateEngine, Sales sales){
		this.templateEngine = templateEngine;
		this.sales = sales;
	}

	/**
	 * Initialize the routes w/ Spark
	 */
	public void initRoutes(){

		staticFileLocation("/public");

		get(HOME_URL, new GetHomeRoute(templateEngine));
		post(CONFIRM_PURCHASE_URL, new PostPurchaseRoute(sales));
		get(PURCHASE_URL, new GetPurchaseRoute(templateEngine, sales));
		post(PRINT_REPORT_URL, new PostReportRoute());
		get(REPORT_URL, new GetReportRoute(templateEngine, sales));
		get(END_DAY_URL, new GetEndDayRoute());
	}
}
