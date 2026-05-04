import java.util.List;

public class BankService {
    private Account account;

    public BankService(Account account){
        this.account = account;
    }


    public String deposit(int amount){
        if(amount >= 0){
            account.setBalance(account.getBalance()+amount);
            account.getTransactions().add(amount+" TL eklendi.");
            return "Hesabınıza "+amount+" TL eklendi.\nYeni bakiye : "+account.getBalance();
        }
        return "Hatalı işlem!";
    }
    public String withdraw(int amount){
        if(account.getBalance() >= amount){
            account.setBalance(account.getBalance()-amount);
            account.getTransactions().add(amount+"TL çekildi.");
            return "Hesabınızdan "+amount+" TL çekildi.\nYeni bakiye : "+account.getBalance();
        }
        account.getTransactions().add("Hatalı işlem.");
        return "Yetersiz bakiye :(\n Hesabınızda "+account.getBalance()+"TL bulunuyor.";
    }

    public String showBalance(){
        account.getTransactions().add("Bakiye gösterildi." +account.getBalance());
        return "Hesabınızda "+account.getBalance()+" TL bulunuyor.";
    }

    public List<String> showTransactions(){

        return account.getTransactions();
    }

}
