import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {

    private Scanner input = new Scanner(System.in);
    private RuleEngine ruleEngine = new RuleEngine();

    private NormalPlayer player;
    private Dealer dealer;
    private Deck deck;

    // Game flow in while loop

    public void startGame() {
    	
        System.out.println("🃏 Welcome to Blackjack!");

        //get name for player
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        player = new NormalPlayer(playerHand, name); 
        dealer = new Dealer(dealerHand); 
        System.out.println("💰 Starting balance: " + player.getBank().getBalance());

        while (player.getBank().getBalance() > 0) {
            System.out.println("\n==============================");
            System.out.println("💰 Current balance: " + player.getBank().getBalance()); // display balance

            player.getHand().clearHand(); // clear hands from previous rounds
            dealer.getHand().clearHand();
            deck = new Deck(); // will create a new deck and shuffle every round
            deck.shuffle();

            

            int bet = takeBet();
            if (bet == 0) break;

            initialDeal(deck);

            if (handleBlackjack(bet)) continue;

            playerTurn(deck);
            dealerTurn(deck);

            resolveRound(bet);
        }

        System.out.println("\n💀 Game over! Final balance: $" + player.getBank().getBalance());
        input.close();
    }

    // take bet

    private int takeBet() {
        while (true) {
            try {
                System.out.print("Enter your bet (0 to quit): ");
                int bet = input.nextInt();
                input.nextLine(); // consume newline

                if (bet == 0) return 0;

                if (bet < 0) {
                    System.out.println("❌ Bet must be positive.");
                }
                else if (!player.getBank().placeBet(bet)) {
                    System.out.println("❌ Insufficient balance!");
                }
                else {
                    return bet;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Enter a number.");
                input.nextLine();
            }
        }
    }

    // deal cards

    private void initialDeal(Deck deck) {
        player.getHand().addCard(deck.deal());
        dealer.getHand().addCard(deck.deal());
        player.getHand().addCard(deck.deal());
        dealer.getHand().addCard(deck.deal());

        player.showHand();
        dealer.showInitialCard();
    }

    // case for blackjack

    private boolean handleBlackjack(int bet) {
        boolean playerBJ = player.getHand().isBlackjack();
        boolean dealerBJ = dealer.getHand().isBlackjack();

        if (!playerBJ && !dealerBJ) return false;

        dealer.revealFullHand();
        System.out.println("\n===== BLACKJACK =====");

        if (playerBJ && dealerBJ) {
            System.out.println("🤝 Both have Blackjack!");
            player.getBank().win(bet);
        }
        else if (playerBJ) {
            System.out.println("🎉 BLACKJACK! You win!");
            player.getBank().win((int)(bet * 2.5));
        }
        else {
            System.out.println("😢 Dealer has Blackjack!");
        }

        player.getBank().displayBalance();
        return true;
    }

    // playerTurn

    private void playerTurn(Deck deck) {
        while (!player.getHand().isBust()) {
            System.out.print("\nHit or Stand? (H/S): ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                player.hit(deck);
            }
            else if (choice.equals("s")) {
                player.stand();
                break;
            }
            else {
                System.out.println("❌ Invalid choice.");
            }
        }
    }

    // dealerTurn

    private void dealerTurn(Deck deck) {
        if (!player.getHand().isBust()) {
            System.out.println("\nDealer's turn...");
            dealer.playTurn(deck);
        }
        dealer.revealFullHand();
    }

    // result

    private void resolveRound(int bet) {
        int result = ruleEngine.determineWinner(player, dealer);

        System.out.println("\n===== RESULT =====");

        if (result == 1) {
            System.out.println("🎉 You win!");
            player.getBank().win(bet * 2);
        }
        else if (result == -1) {
            System.out.println("😢 Dealer wins!");
        }
        else {
            System.out.println("🤝 It's a draw!");
            player.getBank().win(bet);
        }

        player.getBank().displayBalance();
        

    }
}
