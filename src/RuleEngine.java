public class RuleEngine {


    //Check if a Player is bust (>21)
    public boolean isBust(Player p) {
        return p.getHandValue() > 21;
    }

    //Compare numeric totals
    //Returns: 1 -> player higher, -1 -> dealer higher, 0 -> draw
    public int compareHands(int playerTotal, int dealerTotal) {
        if (playerTotal > dealerTotal) {
            return 1;
        } else if (playerTotal < dealerTotal) {
            return -1;
        } else {
            return 0; // Draw
        }
    }

    //Determine winner using Player and Dealer objects
    //Returns: 1 -> Player wins, -1 -> Dealer wins, 0 -> Draw
    public int determineWinner(Player player, Player dealer) {
        //Check busts first
        if (isBust(player)) {
            return -1; //Dealer wins
        }
        if (isBust(dealer)) {
            return 1; //Player wins
        }

        //Get totals
        int playerTotal = player.getHandValue();
        int dealerTotal = dealer.getHandValue();

        //Compare totals
        return compareHands(playerTotal, dealerTotal);
    }
}