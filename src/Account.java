public class Account {
    private int accNum;
    private int pin;
    private double balance;

    public Account(int accNum, int pin, double balance){
        this.accNum=accNum;
        this.pin=pin;
        this.balance=balance;
    }
    public int getAccNum(){
        return this.accNum;
    }
    public int getPin(){
        return this.pin;
    }
    public double getBalance(){
        return this.balance;
    }
    public void depositAmt(double amount){
        this.balance = this.balance+amount;
    }
    public boolean withdrawAmt(double amount){
        if(this.balance-amount<0) return false;
        else{
            this.balance-=amount;
            return true;
        }
    }

}
