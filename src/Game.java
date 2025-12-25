import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🃏 Welcome to Blackjack!");
        // Setup game objects
        Deck deck = new Deck();
        deck.shuffle();

        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        // get player's name
        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();
        NormalPlayer player = new NormalPlayer(playerHand, playerName);
        
        Dealer dealer = new Dealer(dealerHand);

        RuleEngine ruleEngine = new RuleEngine();

        
        
        

        // deal 2 cards to player and dealer
        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        playerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        // Show hand to player and show first card of dealer
        player.showHand();
        
        dealer.showInitialCard();

        // PLAYER TURN
        boolean playerTurn = true;

        while (playerTurn) {
            if (playerHand.isBust()) {
                break;
            }

            System.out.print("\nWould you like to Hit or Stand? (H/S): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                player.hit(deck);
            } else if (choice.equals("s")) {
                player.stand();
                playerTurn = false;
            } else {
                System.out.println("Invalid choice. Please enter H or S.");
            }
        }

        // DEALER TURN
        if (!playerHand.isBust()) {
            System.out.println("\nDealer's turn...");
            dealer.playTurn(deck);
        }

        // Reveal dealer cards
        dealer.revealFullHand();

        // ===== DETERMINE WINNER =====
        int result = ruleEngine.compareHands(playerHand, dealerHand);

        System.out.println("\n===== RESULT =====");
        if (result == 1) {
            System.out.println("🎉 Player wins!");
        } else if (result == -1) {
            System.out.println("😢 Dealer wins!");
        } else {
            System.out.println("🤝 It's a draw!");
        }

        sc.close();
    }
}
