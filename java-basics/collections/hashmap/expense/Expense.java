package hashmap.expense;

public class Expense {
    private String category;
    private int amount;
    private int id;

    Expense(int id,String category, int amount){
        this.category = category;
        this.amount = amount;
        this.id = id;
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
        return  +getId()+"---"+ getCategory() + "---"+getAmount() ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
