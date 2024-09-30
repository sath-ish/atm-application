import java.util.*;

public class ATMServer {
    Map<Integer,Account> accountMap = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    public ATMServer() {
        accountMap.put(987654321, new Account(987654321, 1234, 5000.0));
    }
    public boolean verifyAcc(int accNum, int pin){
        if(accountMap.containsKey(accNum)){
            Account acc = accountMap.get(accNum);
            return acc.getPin()==pin;
        }
        return false;
    }
    public void getAccountType(int accountNum){
        Account account = accountMap.get(accountNum);
        while(true) {
            System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4.Change Account\n5. Exit");
            System.out.print("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    depositCash(account);
                    break;
                case 3:
                    withdrawCash(account);
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
            }
        }
    }
    public void checkBalance(Account account){
        System.out.println("Your Balance : "+account.getBalance());
    }
    public void depositCash(Account account){
        System.out.println("Enter the amount to deposit : ");
        double amt = sc.nextDouble();
        account.depositAmt(amt);
        System.out.println("Amount Deposited\nNew Balance : "+account.getBalance());
    }
    public void withdrawCash(Account account){
        System.out.println("Enter the amount to withdraw : ");
        double amt = sc.nextDouble();
        if(account.withdrawAmt(amt)){
            System.out.println("Amount withdrawn\nNew Balance : "+account.getBalance());
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
}
