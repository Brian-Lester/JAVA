import java.util.function.ToDoubleFunction;
import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    static int numOfAccounts;
    static double accountsBalance;
    private int checkingAccountNumber;
    private int savingAccountNumber;

    public BankAccount(){

    };

    public BankAccount(double checkingBalance) {
        this.checkingBalance = checkingBalance;
        numOfAccounts +=1;
        accountsBalance += checkingBalance;
    }

    public BankAccount(double checkingBalance, double savingBalance) {
        Random  random = new Random();
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        checkingAccountNumber = random.nextInt(Integer.MAX_VALUE);
        savingAccountNumber = random.nextInt(Integer.MAX_VALUE);
        numOfAccounts +=2;
        accountsBalance = (checkingBalance + savingBalance);
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double getAccountsBalance(){
        return accountsBalance;
    }

    public int numOfAccounts(){
        return numOfAccounts;
    }

    public int getCheckingAccountNum(){
        return checkingAccountNumber;
    }
    public int getSavingAccountNum(){
        return savingAccountNumber;
    }

    public String deposit(double checking, double saving){
        checkingBalance += checking;
        savingBalance += saving;
        accountsBalance = (checkingBalance + savingBalance);
        return "thanks for using Brians Bank have a  nice day";
    }

    public String withdraw(double checking, double saving){
        if(checking <= checkingBalance && saving <= savingBalance ){
            checkingBalance -= checking;
            savingBalance -= saving;
            accountsBalance = (checkingBalance + savingBalance);
            return "thanks for using Brians Bank have a  nice day";
        }
        else if(checking > checkingBalance){
            return "insufficent funds you have" + checkingBalance + "in your checking account";
        }
        else{
            return"insufficent funds you have " + savingBalance + " in your savings account";
        }
    }



}
