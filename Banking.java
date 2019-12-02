import java.util.Scanner;

class Banking {
    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n========================================\n\t---WELCOME TO BANKING---\n========================================\n");
        System.out.println("Please enter no. of account holders for banking: ");

        int n = sc.nextInt();

        BankOperation A[] = new BankOperation[n];

        for (int i = 0; i < A.length; i++) {
            A[i] = new BankOperation();
            A[i].openAcc();
        }

        int choice;

        System.out.println("\n***********************************\n");

        do {
            System.out.println("\n\n\t1. Display all\n\t2. View account\n\t3. Credit\n\t4. Debit\n\t5. Exit");
            
            System.out.println("\nDear user, please enter your choice: \t");
            
            choice = sc.nextInt();

            switch (choice) {
            case 1:
                System.out.println("\n___________________________________\n\t\nALL ACCOUNTS\n___________________________________\n");
                for (int i = 0; i < A.length; i++) {
                    A[i].dispAcc();
                }
                break;

            case 2:
                System.out.println("\n___________________________________\n\tVIEW ACCOUNT\n___________________________________\nEnter Account Number:");

                String account_new = sc.next();
                System.out.println("\nDETAILS----------------------------\n");
                boolean found = false;
                for (int i = 0; i < A.length; i++) {
                    found = A[i].find(account_new);
                    if (found)
                    {
                    A[i].dispAcc();
                    break;
                    }
                    
                    }
                    if (!found) {
                        System.out.println("...................................\n");
                        System.out.println("Account doesn't exist");
                        System.out.println("...................................\n");
                    }

                break;
            case 3:
                System.out.println("\n___________________________________\n\tDEPOSIT\n___________________________________\n");
                System.out.println("Enter Account Number: ");

                String account_new2 = sc.next();
                found = false;
                for (int i = 0; i < A.length; i++) {
                    found=A[i].find(account_new2);
                    if (found) {
                        A[i].credit();
                        break;
                    }
                }
                if(!found){
                    System.out.println("...................................\n");
                    System.out.println("Account doesn't exist");
                    System.out.println("...................................\n");
                }
                break;

            case 4:
                System.out.println("\n___________________________________\n\tWITHDRAWAL\n___________________________________\n");
                System.out.println("Enter Account Number: ");

                String account_new1 = sc.next();
                found = false;
                for (int i = 0; i < A.length; i++) {
                    found = A[i].find(account_new1);                    
                    if (found) {
                        A[i].debit();
                        break;
                    }
                }
                if(!found){
                    System.out.println("...................................\n");
                    System.out.println("Account doesn't exist");
                    System.out.println("...................................\n");
                }
                break;
                
            case 5:
                System.out.println("...................................\n");
                System.out.println("Thank you!");
                System.out.println("...................................\n");
                break;
            }

        } while (choice != 5);

        sc.close();
    }
}

class BankOperation {
    String name, account_old;
    long money;
    long bal;
    long min, max;
    Scanner sc = new Scanner(System.in);
    

    // Opening the Account
    void openAcc() {
        System.out.println("-----------------------------------\n");
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("\nAccount Number: ");
        account_old = sc.nextLine();
        System.out.println("\nBalance: ");
        bal = sc.nextLong();
    
        min = bal;
        max = bal;
    }
    

    // Show the account
    void dispAcc() {
        System.out.println("\tName : " + name + "\n\tAccount no. : " + account_old + "\n\tBalance : " + bal
                + "\n-----------------------------------");
    }

    // Method to Deposit the money
    void credit() {
        
        System.out.println("\nEnter your deposit amount: ");
        money = sc.nextLong();
        bal = bal + money;
        System.out.println("...................................\n");
        System.out.println("Your Balance is : " + bal);
        System.out.println("...................................\n");
        if (bal>max) 
        {
            max = bal;
            
        } 
        else 
        {
                min = bal;
     
        }
        System.out.println("Your minimum balance is: " + min);  
        System.out.println("Your maximum balance is: " + max);
        System.out.println("...................................\n");
    }

    // Method to withdraw the money
    void debit() {
        System.out.println("\nEnter your withdrawal amount: ");
        money = sc.nextLong();
        if (bal >= money) {
            bal = bal - money;
            System.out.println("...................................\n");
            System.out.println("Your Balance is : " + bal);
            System.out.println("...................................\n");
            if (bal<min) 
            {
                min = bal;   
            }
            else
            {
                max = bal;
            }             

            System.out.println("Your minimum balance is: " + min);  
            System.out.println("Your maximum balance is: " + max);
            System.out.println("...................................\n");
        } 
        else 
        {
            System.out.println("...................................\n");
            System.out.println("your minimum balance is low. Transaction failed...");
            System.out.println("...................................\n");
        }

    }
    // method to find an Account
    boolean find(String account_new)
    {
        if (account_old.equals(account_new))
        {
            return(true);
        }
        return(false);
    }

}
