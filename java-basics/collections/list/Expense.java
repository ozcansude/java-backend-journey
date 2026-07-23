package list;


public class Expense {
    private int id;
    private String description;
    private String category;
    private double amount;

    Expense(int id, String description, String category, double amount){
        this.setAmount(amount);
        this.setCategory(category);
        this.setDescription(description);
        this.setId(id);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Harcama detayı : "+description + " - Harcama miktarı : "+amount+ "\n";
    }


}
