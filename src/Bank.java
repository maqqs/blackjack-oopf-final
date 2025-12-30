
public class Bank {
    
    private int balance;
    

    public Bank(int balance) {
        this.balance = balance;
    }
    

    public boolean placeBet(int amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    

    public void win(int amount) {
        balance += amount;
    }
    
// no lose because placeBet() deducts money upfront
    

    public int getBalance() {
        return balance;
    }

    public boolean canAfford(int amount) {
        return balance >= amount;
    }

    public void displayBalance() {
        System.out.println("💰 Balance: $" + balance);
    }
}