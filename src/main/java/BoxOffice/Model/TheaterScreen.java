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

	/**
	 * Constructor - creates a new instance of a screen
	 * @param availTix - the initial amount of tickets available
	 */
	public TheaterScreen(int availTix){
		this.availTix = availTix;
		this.numSales = 0;  // initially 0 tickets sold
	}

	public int getNumSales(){ return numSales; }

	public int getAvailTix(){ return availTix; }

	/**
	 * Update number of sales & number of available tickets
	 * @param numTix - number of tickets being purchased
	 */
	public void makePurchase(int numTix){
		// check that there are enough tickets to satisfy the purchase
		if(availTix >= numTix){
			numSales += numTix;
			availTix -= numTix;
		}
		else{
			// TODO: Exception?
		}
	}



}
