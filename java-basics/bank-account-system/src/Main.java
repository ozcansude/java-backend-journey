public class Main {
    public static void main(String[] args){
/*
Account oluştur
Para yatır, bi de yanlış para yatır
Para çek,
Yetersiz bakiye dene
Transaction geçmişini yazdır
 */

        Account account = new Account(46,"Sude",34000);

        BankService bankService = new BankService(account);

        System.out.println(bankService.deposit(12000));
        System.out.println(bankService.deposit(-1000));
        System.out.println(bankService.withdraw(6000));
        System.out.println(bankService.withdraw(59000));
        System.out.println(bankService.showTransactions());

    }
}
