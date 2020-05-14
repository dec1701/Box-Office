package BoxOffice.Controller;

import BoxOffice.Model.TheaterScreen;

/**
 * Processes all purchases
 */
public class Sales {

	// all the screens in the theater, stored in an array
	private TheaterScreen screens[];

	/**
	 * Constructor - creates a new instance of the Sales
	 * @param tixPerScreen - the initial amount of available tickets
	 *                     for each screen
	 */
	public Sales(int tixPerScreen){
		// creates all 5 screens
		screens = new TheaterScreen[5];
		for(int i = 0; i < 5; i++){
			screens[i] = new TheaterScreen(tixPerScreen);
		}
	}


	public void makePurchase(int screenNum, int numTix){
		screens[screenNum].makePurchase(numTix);
	}

	/**
	 * Constructs the purchase reports for all the screens
	 * @return the report for all screens
	 */
	public String report(){
		String reportStr = "Comprehensive Sales Report:\n\n";
		for(int i = 0; i < 5; i++){
			reportStr += report(i) + "\n\n";
		}
		return reportStr;
	}

	/**
	 * Constructs the purchase report for the specified screen
	 * @param screenNum - the number of the screen to be reported
	 * @return - the report for the screen
	 */
	public String report(int screenNum){
		return "Tickets sold for Screen # " + screenNum +":\n\t" +
				screens[screenNum].getNumSales() + "\n" +
				"Tickets remaining:\n\t" +
				screens[screenNum].getAvailTix();
	}
}
