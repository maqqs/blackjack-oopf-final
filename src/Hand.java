import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	private int totalValue;
	private int numAces;
	
	public Hand(ArrayList<Card> cards, int totalValue, int numAces) {
		this.cards = new ArrayList<>();
		this.totalValue = 0;
		this.numAces = 0;
	}
	//add cards to hand
	public void addCard(Card c) {
		cards.add(c);
		totalValue += c.getValue();
		
		//1 or 11 for ACES
		if (c.getRank().equals("Ace")){
			numAces++;
		}
	}
	
	
	//get all cards in hand
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	
	//get total value according to ACES logic(1 or 11)
	public int getTotalValue() {
		int value = totalValue;
		int aces = numAces;
		
		while(value > 21 && aces >0) {
			value -=10;
			aces--;
		}
		return value;
	}
	
	
	//check if hand is over 21
	public boolean isBust() {
		return getTotalValue()>21;
	}
	
	
	//clear hand for new round
	public void clearHand() {
		cards.clear();
		totalValue = 0;
		numAces = 0; 
	}
	
	
	//show all cards in hand
	public void showCards() {
        System.out.print("Cards: ");
        for (Card card : cards) {
            System.out.print(card.toString() + " | ");
        }
        System.out.println("\nTotal Value: " + getTotalValue());
    }
	
	
}