public class Card {
	private final String suit;
	private final String rank;
	private final int value;
	
	public Card(String rank, String suit, int value) {
		super();
		this.rank = rank;
		this.suit = suit;
		this.value = value;
	}

	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	// No setter because any individual card's suit/rank can't be changed
	
	@Override
	public String toString() {
		return String.format("%s"+" of "+"%s", rank, suit);
	}
	
	
	
	
	

}