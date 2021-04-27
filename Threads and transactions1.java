import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Threads extends Thread {
    private Bank bank;
    private Account poluchatel;
    private Account otpravitel;
    Double amount;

    @Override
    public void run() {
        bank.makeTransaction(otpravitel, poluchatel, amount);
    }

    public void setResources(Bank newBank, Account newOtpravitel, Account newPoluchatel, Double newAmount) {
        bank = newBank;
        otpravitel = newOtpravitel;
        recipient = newPoluchatel;
        amount = newAmount;
    }
}


public class Transaction {
    static private int count = 0;
    private int ID;
    static Lock lock = new ReentrantLock();

    Date date;

    private boolean result_transaction;
    private String nameAccountOtpravitel;
    private String nameAccountPoluchatel;
    private int otpravitelBankAccNumber;
    private int poluchatelBankAccNumber;
    private Double transferAmount;

    // initial value
    private Double otpravitelInitialBalanceValue;
    private Double poluchatelInitialBalanceValue;

    // subsequent value
    private Double otpravitelSubsequentBalanceValue;
    private Double poluchatelSubsequentBalanceValue;

    Transaction(Account otpravitel, Account poluchatel, Double amount) {

            nameAccountOtpravitel = otpravitel.getName();
            nameAccountPoluchatel = poluchatel.getName();
            otpravitelBankAccNumber = otpravitel.getNumberBankAcc();
            poluchatelBankAccNumber = poluchatel.getNumberBankAcc();
            transferAmount = amount;

            lock.lock();
            if (otpravitel.balanceAcc() >= amount) {

                otpravitelInitialBalanceValue = otpravitel.balanceAcc();
                otpravitel.setBankAcc(-amount);
                otpravitelSubsequentBalanceValue = otpravitel.balanceAcc();

                poluchatelInitialBalanceValue = poluchatel.balanceAcc();
                poluchatel.setBankAcc(amount);
                poluchatelSubsequentBalanceValue = poluchatel.balanceAcc();

                ID = ++count;
                date = new Date();

                lock.unlock();
            

                result_transaction = true;
            }

             else {
                date = new Date();
                result_transaction = false;
            }


    }

    void printShortInformation() {
        if (result_transaction) {
            System.out.println(ID + " " + date + " " + nameAccountOtpravitel + " transferred " + transferAmount + " dollars to " + nameAccountPoluchatel);
        } else {
            System.out.println("The transaction № " + ID + " was not completed. Errors");
        }
    }

    

}

