package BoxOffice.View;

import static spark.Spark.*;
import BoxOffice.Controller.Sales;

public class WebServer {

	// URLs for each page
	private static final String HOME_URL = "/";
	private static final String PURCHASE_URL = "/purchase";
	private static final String CONFIRM_PURCHASE_URL = "/confirm";
	private static final String CHOOSE_REPORT_URL = "/report";
	private static final String PRINT_REPORT_URL = "/report/print";

	private Sales sales;

	public WebServer(final Sales sales){
		this.sales = sales;
	}

	public void initRoutes(){
		get(HOME_URL, new GetHomeRoute());
		post(PURCHASE_URL, new PostPurchaseRoute());
		get(CONFIRM_PURCHASE_URL, new GetPurchaseRoute(sales));
		post(CHOOSE_REPORT_URL, new PostReportRoute());
		get(PRINT_REPORT_URL, new GetReportRoute(sales));
	}
}
