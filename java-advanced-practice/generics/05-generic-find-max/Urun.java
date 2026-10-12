public class Urun implements Comparable<Urun>{
    private String name;
    private Integer price;

    public Urun(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }

    @Override
    public int compareTo(Urun digerUrun) {
        return Integer.compare(this.price, digerUrun.getPrice());
    }
    @Override
    public String toString(){
        return "Ürün adı : "+ this.getName() + " --- Ürün fiyatı : "+ this.getPrice();
    }
}
