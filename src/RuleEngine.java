public class RuleEngine {

    // Check if a hand is bust (>21)
    public boolean isBust(Hand hand) {
        return hand.getTotalValue() > 21;
    }

    // Compare player and dealer hands
    // Returns:
    // 1  -> Player wins
    // -1 -> Dealer wins
    // 0  -> Draw
    public int compareHands(Hand player, Hand dealer) {

        // If player busts, dealer wins
        if (isBust(player)) {
            return -1;
        }

        // If dealer busts, player wins
        if (isBust(dealer)) {
            return 1;
        }

        int playerValue = player.getTotalValue();
        int dealerValue = dealer.getTotalValue();

        // Compare values
        if (playerValue > dealerValue) {
            return 1;
        } else if (playerValue < dealerValue) {
            return -1;
        } else {
            return 0; //Draw
        }
    }
}