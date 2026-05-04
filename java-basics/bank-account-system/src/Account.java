import java.util.ArrayList;
import java.util.List;

public class Account{
    private int id;
    private String ownerName;
    private double balance;
    private List<String> transactions;

    public Account(int id, String ownerName,double balance){
        this.id = id;
        this.balance = balance;
        this.ownerName = ownerName;
        this.transactions = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public String toString(){
        return "Owner Name : "+this.ownerName
                +"Balance : "+ this.balance;
    }

}