public class Dealer extends Player {

    // Constructor
    public Dealer(Hand hand) {
    	super(hand); 
    }

   
     // Dealer's turn logic: Hits until total value is 17 or higher.
     // This is a new method specific to Dealer.
    public void playTurn(Deck deck) {
        while (getHandValue() < 17) {
            Card c = deck.deal();
            // just in case break if deck run out / empty
            if (c == null) break;
            hand.addCard(c);
        }
    }

 
     // Override showHand() to show only the dealer's upcard initially.
    @Override
    public void showHand() {
        if (!hand.getCards().isEmpty()) {
            System.out.println("Dealer's Upcard: " + hand.getCards().get(0));
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
        hand.showCards();
    }
}