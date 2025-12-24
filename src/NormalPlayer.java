
public class NormalPlayer extends Player {
	
	private String name;
	//private Bank bank;
	

	public NormalPlayer(Hand hand, String name) {
		super(hand);
		this.name = name;
		//this.bank = bank;
	}

	
	
	
	/**
     * Stand - player chooses not to draw more cards
     * Simply ends the player's turn
     */
    public void stand() {
        System.out.println(name + " stands with " + getHandValue());
    }
    
    /**
     * Hit - player draws one card from deck
     * @param deck The deck to draw from
     */
    public void hit(Deck deck) {
        Card drawnCard = deck.deal();
        hand.addCard(drawnCard);
        System.out.println(name + " draws: " + drawnCard.toString());
        System.out.println(name + "'s total: " + getHandValue());
        
        if (hand.isBust()) {
            System.out.println("💥 " + name + " busts with " + getHandValue() + "!");
        }
    }
    
    /**
     * Place bet - deduct bet amount from bank
     * @param amount Bet amount
     */
    /*public void placeBet(int amount) {
        if (bank.getBalance() >= amount) {
            bank.lose(amount);
            System.out.println(name + " bets $" + amount);
            System.out.println("Remaining balance: $" + bank.getBalance());
        } else {
            System.out.println("❌ Insufficient balance! You have $" + bank.getBalance());
        }
    }
    */
    
    
    @Override
	public void playTurn(Deck deck) {
        // This is controlled by Game class with user input
        // Player manually chooses hit() or stand()
        // This implementation satisfies the abstract method requirement
        System.out.println(name + "'s turn (controlled by user input in Game class)");
    }
	
	@Override
	public void showHand() {
        System.out.println("\nPlayer's Full Hand:");
        hand.showCards();
        System.out.println("Total Value: " + getHandValue());
    }
}
