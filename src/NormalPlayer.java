
public class NormalPlayer extends Player {
	
	private String name;
	private Bank bank;
	


	public NormalPlayer(Hand hand, String name) {
		super(hand);
		this.name = name;
		this.bank = new Bank(100);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	
	// stand 
    public void stand() {
        System.out.println(name + " stands with " + getHandValue());
    }
    
    // hit - player draws one card from deck
    public void hit(Deck deck) {
        Card drawnCard = deck.deal();
        hand.addCard(drawnCard);
        System.out.println(name + " draws: " + drawnCard.toString());
        hand.showCards();
        
        if (hand.isBust()) {
            System.out.println("💥 " + name + " busts with " + getHandValue() + "!");
        }
    }

   
	
	@Override
	public void showHand() {
		System.out.printf("%n%s's Cards:%n", name);
        hand.showCards();
        System.out.println();
    }

	public String getName() {
		return name;
	}


}
