import java.util.*;
public class ATMInterface {
    public static void main(String[] args){
        ATMServer serv = new ATMServer();
        int accountNum;
        int pin;
        int chances=3;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter account number : ");
            accountNum = sc.nextInt();
            System.out.print("Enter the pin : ");
            pin = sc.nextInt();
            if (serv.verifyAcc(accountNum, pin)) serv.getAccountType(accountNum);
            else {
                System.out.println("WRONG CREDENTIALS!!!");
                chances--;
                if(chances==0){
                    System.out.println("Account is BLOCKED");
                    break;
                }
                System.out.println("Only "+chances+" chances left");
                continue;
            }
            System.out.println("Do you want to exit (y/n) : ");
            if(sc.next().charAt(0)=='y') break;
        }
    }
}
