import java.util.ArrayList;


public class BankAcc {
    private int numberBankAcc;
    private Double ammount;

    BankAcc() {
        numberBankAcc = (int) (Math.random() * 1000000000);
        ammount = Math.random() * 1000;

    }

    int get_numberBankAcc() {
        return numberBankAcc;
    }


    void setMoney(Double x) {
        ammount += x;
    }

    Double balance() {
        return ammount;
    }
   }


public class Account {

    private String FirstName;
    private String LastName;
    private BankAcc NEWBankAcc;

    Account(String userFirstName, String userLastName) {
        FirstName = userFirstName;
        LastName = userLastName;
        NEWBankAcc = new BankAcc();
    }

    //Получаем значение

    String getName() {
        return (FirstName + " " + LastName);
    }

    int getNumberBankAcc() {
        return NEWBankAcc.get_numberBankAcc();
    }

    Double balanceAcc() {
        return NEWBankAcc.balance();
    }

    // Устанавливаем значения

    void setBankAcc(Double x) {
        NEWBankAcc.setMoney(x);
    }

}


public class Bank {
    private String bankName;
    private ArrayList<Transaction> transactionsList = new ArrayList();

    Bank(String newBankName) {
        bankName = newBankName;
    }

    public void pushBackTransaction(Transaction x) {
        transactionsList.add(x);
    }

    public void printTransactionList() {
        for (int i = 0; i < transactionsList.size(); ++i) {
            transactionsList.get(i).printFullInformation();
        }
    }

    public void makeTransaction(Account sender, Account recipient, Double amount) {
        for (int i = 0; i < 5; ++i) {
            Transaction x = new Transaction(sender, recipient, amount);
            pushBackTransaction(x);
        }
    }
}







