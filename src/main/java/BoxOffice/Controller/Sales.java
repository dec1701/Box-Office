package BoxOffice.Controller;

import BoxOffice.Model.TheaterScreen;

/**
 * Responsible for handling information between the Model and View
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

	/**
	 * Updates the number of sales and number of remaining tickets for
	 * the designated screen
	 * @param screenNum - the number of the screen
	 * @param numTix - the number of tickets being purchases
	 * @return 1 if successful, 0 otherwise
	 */
	public int makePurchase(int screenNum, int numTix){
		return screens[screenNum].makePurchase(numTix);
	}

	/**
	 * Updates the number of sales and number of remaining tickets for
	 * the designated screen
	 * @param screenNum - the number of the screen
	 * @param numTix - the number of tickets being returned
	 * @return 1 is successful, 0 otherwise
	 */
	private int makeReturn(int screenNum, int numTix){ return screens[screenNum].makeReturn(numTix); }

	/**
	 * Updates the number of sales and number of remaining tickets for both
	 * screens
	 * @param screenNum - the screen being purchased from
	 * @param returnScreen - the screen having tickets returned
	 * @param numTix - the number of tickets being exchanged
	 * @return 1 if successful, 0 if new purchase fails, -1 if return fails
	 */
	public int makeExchange(int screenNum, int returnScreen, int numTix){
		if(screens[screenNum].canPurchase(numTix)){
			if(screens[returnScreen].canReturn(numTix)){
				makePurchase(screenNum, numTix);
				makeReturn(returnScreen, numTix);
				return 1;
			}
			return -1;
		}
		return 0;
	}

	/**
	 * Gets the remaining amount of available tickets for the
	 * designated screen
	 * @param screenNum - the number of the screen
	 * @return the number of available tickets
	 */
	public int getRemaining(int screenNum){
		return screens[screenNum].getAvailTix();
	}

	/**
	 * Gets the amount of sales for the designated screen
	 * @param screenNum - the number of the screen
	 * @return the number of sales
	 */
	public int getSales(int screenNum){
		return screens[screenNum].getNumSales();
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
