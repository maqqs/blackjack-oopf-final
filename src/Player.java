
public abstract class Player {
	protected Hand hand;

	public Player(Hand hand) {
		this.hand = hand;
	}
	
	//get current hand value
	public int getHandValue() {
		return hand.getTotalValue();
	}
	
	//Play turn - behavior differs for Player vs Dealer
	public abstract void playTurn(Deck deck);
	
	
	/*Show hand - displays differently for Player vs Dealer
    * Polymorphism: NormalPlayer shows all cards, Dealer shows only upcard
    */
	public abstract void showHand();
	

	
	
	
	
}
