package hashmap.expense;

public class Expense {
    private String category;
    private int amount;

    Expense(String category, int amount){
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString(){
        return  getCategory() + "  ---  "+getAmount() ;
    }
}
