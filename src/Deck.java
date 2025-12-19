import java.util.*;

public class Deck {
	private ArrayList<Card> cards= new ArrayList<Card>();
	
	public Deck() {
		String[] ranks= {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suits= {"Spade", "Hearts" , "Clubs", "Diamond"};
		int[] values= {1,2,3,4,5,6,7,8,9,10,10,10,10};
		
		for (String s: suits) {
			for(int i=0; i<ranks.length; i++) {
				cards.add(new Card(ranks[i],s,values[i]));
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return String.format("Deck [cards=%s]", cards);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card deal() {
		if(cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
	
	public void resetDeck() {
	    cards.clear(); 

	    String[] ranks= {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suits= {"Spade", "Hearts" , "Clubs", "Diamond"};
		int[] values= {1,2,3,4,5,6,7,8,9,10,10,10,10};
		
		for (String s: suits) {
			for(int i=0; i<ranks.length; i++) {
				cards.add(new Card(ranks[i],s,values[i]));
			}
		}
	}
	
	public void cardsLeft() {
		System.out.println("Cards left in deck: " + cards.size());
			
		}

 }