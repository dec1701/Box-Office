package BoxOffice;

import BoxOffice.Controller.Sales;
import BoxOffice.View.WebServer;


/**
 *
 */
public class App 
{
	// If an amount of tickets per screen has not been specified
	// through command line, the
	private static int defaultTPS = 20;

	private WebServer webServer;

	private App(final WebServer webServer){
		this.webServer = webServer;
	}

	private void initRoutes(){
		webServer.initRoutes();
	}

	public static void main(String[] args) {

		// INITIALIZING CONTROLLER CLASS

		Sales sales;

		if(args.length > 0){
			sales = new Sales(defaultTPS);
		}
		else{
			try {
				int tixPerScreen = Integer.parseInt(args[0]);
				sales = new Sales(tixPerScreen);
			}catch(NumberFormatException e){
				sales = new Sales(defaultTPS);
			}
		}

		// INITIALIZING WEB SERVER
		final WebServer webServer = new WebServer(sales);

		// INITIALIZING APP
		final App app = new App(webServer);
		app.initRoutes();
	}


}
