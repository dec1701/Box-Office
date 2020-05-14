package BoxOffice;

import BoxOffice.Controller.Sales;


/**
 *
 */
public class App 
{
	// If an amount of tickets per screen has not been specified
	// through command line, the
	private static int defaultTPS = 20;

	public static void main(String[] args) {

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
	}
}
