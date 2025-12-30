
public class Player {
	protected Hand hand;

	public Player(Hand hand) {
		this.hand = hand;
	}
	
	public Hand getHand() {
		return hand;
	}

	// Get current hand value
	public int getHandValue() {
		return hand.getTotalValue();
	}
	
	
	
	/*Show hand - displays differently for Player vs Dealer
    * NormalPlayer shows all cards, Dealer shows only upcard
    */
	public void showHand() {
		
	}
	

	
	
	
	
}
