package collections.streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample{
    public static void main(String[] args){
    Product product = new Product(
            "macbook",
            70000,
            "pc"
    );
    Product product2 = new Product(
            "iphone",
            70000,
            "phone"
    );
        Product product3 = new Product(
                "airpods",
                13000,
                "headphones"
        );
        Product product4 = new Product(
                "applewatch",
                20000,
                "saat"
        );

        List<Product> productList = Arrays.asList(product,product2,product3,product4);

        productList.stream()
                   .filter(p -> p.getPrice() > 50000)
                   .forEach(p -> System.out.println("❖Expensive product : "+ p.toString()+"\n"));

    }
}

class Product {
    private String name;
    private double price;
    private String category;

    Product(String name,double price,String category){
        this.setCategory(category);
        this.setName(name);
        this.setPrice(price);
    }
    public String toString(){
        return "Product Name : "+ getName() + "\nProduct Price : "+ getPrice();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
