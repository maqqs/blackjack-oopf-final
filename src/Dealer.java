public class Dealer extends Player {

    // Constructor
    public Dealer(Hand hand) {
    	super(hand); 
    }

   
     // Dealer's turn logic: Hits until total value is 17 or higher.

    public void playTurn(Deck deck) {
        while (getHandValue() < 17) {
            Card c = deck.deal();
            getHand().addCard(c);
        }
    }

 
     // Override showHand() to show only the dealer's upcard initially.
    @Override
    public void showHand() {
        if (!getHand().getCards().isEmpty()) {
            System.out.println("Dealer's Upcard: " + getHand().getCards().get(0));
        } else {
            System.out.println("Dealer has no cards yet.");
        }
    }


      //Show dealer's initial card 
    public void showInitialCard() {
        showHand();
    }


     // Reveal the dealer's full hand (used at the end of the round).
     
    public void revealFullHand() {
        System.out.println("\nDealer's Full Hand:");
        getHand().showCards();
    }
}