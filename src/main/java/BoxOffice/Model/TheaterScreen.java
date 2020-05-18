package BoxOffice.Model;

/**
 * Represents a screen in the movie theater that will be playing
 * one movie
 */
public class TheaterScreen {

	// The amount of tickets sold
	private int numSales;

	// The amount of tickets available for sale
	private int availTix;

	// The maximum amount of tickets available
	private int availMax;

	/**
	 * Constructor - creates a new instance of a screen
	 * @param availTix - the initial amount of tickets available
	 */
	public TheaterScreen(int availTix){
		this.availMax = availTix;
		this.availTix = availTix;
		this.numSales = 0;  // initially 0 tickets sold
	}

	// Accessor methods
	public int getNumSales(){ return numSales; }
	public int getAvailTix(){ return availTix; }

	/**
	 * Checks if there are enough tickets to perform a purchase w/ numTix
	 * @param numTix - the number of tickets trying to be purchased
	 * @return true if there are enough availTix, false otherwise
	 */
	public boolean canPurchase(int numTix){ return availTix >= numTix; }

	/**
	 * Checks that the return doesn't result in more tickets than the initial
	 * amount
	 * @param numTix - the number of tickets trying to be returned
	 * @return true if possible, false otherwise
	 */
	public boolean canReturn(int numTix){ return availTix + numTix <= availMax; }

	/**
	 * Update number of sales & number of available tickets
	 * @param numTix - number of tickets being purchased
	 * @return 1 if successful, 0 otherwise
	 */
	public int makePurchase(int numTix){
		// check that there are enough tickets to satisfy the purchase
		if(canPurchase(numTix)){
			numSales += numTix;
			availTix -= numTix;
			return 1;
		}
		return 0;
	}

	/**
	 * Update number of sales & number of available tickets
	 * @param numTix - number of tickets being returned
	 * @return 1 if successful, 0 otherwise
	 */
	public int makeReturn(int numTix){
		// check that user is not trying to return more tickets than there are
		// available
		if(canReturn(numTix)) {
			numSales -= numTix;
			availTix += numTix;
			return 1;
		}
		return 0;
	}
}
