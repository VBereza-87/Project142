public class Main {

    public static void main(String[] args) {

        Bank VOLbank = new Bank("VOLbank");

        Account card_1 = new Account("Artem", "Shabalov");
        Account card_2 = new Account("Mike", "Ivanov");
        Account card_3 = new Account("Sveta", "Igorova");
        Account profile_4 = new Account("Vitya", "Novikov");


        Threads thread_1 = new Threads();
        Threads thread_2 = new Threads();
        Threads thread_3 = new Threads();
        Threads thread_4 = new Threads();
        thread_1.setResources(VOLbank, card_1, card_2, 20.0);
        thread_2.setResources(VOLbank, card_1, card_3, 10.0);
        thread_3.setResources(VOLbank, card_1, card_4, 40.0);
        thread_4.setResources(VOLbank, card_4, card_2, 5.0);


        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        VOLbank.printTransactionList();
