

public class TestBank {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount(100,100);
        // BankAccount account2 = new BankAccount(500,500);

        System.out.println(account1.getAccountsBalance());
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingBalance());
        System.out.println(account1.numOfAccounts());
        System.out.println(account1.deposit(1000, 0));
        System.out.println(account1.withdraw(1000, 1000));
        System.out.println(account1.getAccountsBalance());
        System.out.println(account1.getCheckingAccountNum());
        System.out.println(account1.getSavingAccountNum());

        // System.out.println(account2.getAccountsBalance());
        // System.out.println(account2.getCheckingBalance());
        // System.out.println(account2.getSavingBalance());
        // System.out.println(account2.numOfAccounts());
    }
}
