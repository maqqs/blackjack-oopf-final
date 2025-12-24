/**
 * Bank class - manages player's money/chips
 * Aggregation relationship with NormalPlayer
 * Based on UML diagram specifications
 */
public class Bank {
    
    // Attribute from UML
    private int balance;
    
    /**
     * Constructor - creates bank with initial balance
     * @param balance Initial balance/chips
     */
    public Bank(int balance) {
        this.balance = balance;
    }
    
    /**
     * Place bet - deduct amount from balance
     * Same as lose() but more semantic for betting context
     * @param amount Amount to bet
     * @return true if successful, false if insufficient balance
     */
    public boolean placeBet(int amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    
    /**
     * Win - add winnings to balance
     * @param amount Amount won
     */
    public void win(int amount) {
        balance += amount;
    }
    
    /**
     * Lose - deduct loss from balance
     * @param amount Amount lost
     */
    public void lose(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("⚠️ Warning: Trying to deduct more than available balance!");
            balance = 0;
        }
    }
    
    /**
     * Get current balance
     * @return current balance
     */
    public int getBalance() {
        return balance;
    }
    
    /**
     * Check if player has enough money to bet
     * @param amount Amount to check
     * @return true if balance is sufficient
     */
    public boolean canAfford(int amount) {
        return balance >= amount;
    }
    
    /**
     * Display balance
     */
    public void displayBalance() {
        System.out.println("💰 Balance: $" + balance);
    }
}