package BoxOffice.Model;

/**
 * Represents a screen in the movie theater that will be playing
 * one movie
 */
public class TheaterScreen {

	// The amount of tickets sold
	private int numSales;

	// The amount of tickets available for sale
	private int availTickets;

	/**
	 * Constructor - creates a new instance of a screen
	 * @param availTickets - the initial amount of tickets available
	 */
	public TheaterScreen(int availTickets){
		this.availTickets = availTickets;
		this.numSales = 0;  // initially 0 tickets sold
	}

	/**
	 * Update number of sales & number of available tickets
	 * @param numTickets - number of tickets being purchased
	 */
	public void makePurchase(int numTickets){
		// check that there are enough tickets to satisfy the purchase
		if(availTickets >= numTickets){
			numSales += numTickets;
			availTickets -= numTickets;
		}
		else{
			// TODO: Exception?
		}
	}



}
