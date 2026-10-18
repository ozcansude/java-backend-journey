package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample{
    public static void main(String[] args){
    Product product = new Product(
            "macbook",
            80000,
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
                "watch"
        );
        Product product5 = new Product(
                "samsung",
                70000,
                "phone"
        );

        List<Product> productList = Arrays.asList(product,product2,product3,product4,product5);

        productList.stream()
                   .filter(p -> p.getPrice() > 50000)
                   .forEach(p -> System.out.println("❖Expensive product : "+ p +"\n"));

        productList.stream()
                .filter(p -> p.getCategory().equals("phone"))
                .forEach(p -> System.out.println("~"+p.getName()));

        productList.stream()
                .filter(p -> p.getCategory().equals("phone") && p.getPrice() > 50000)
                .forEach(p -> System.out.println(p.getName()));

        //Ürün listesindeki bütün ürünlerin fiyatlarını %10 artırarak ekrana yazdır.
        productList.stream()
                .map(p -> p.getName() + "  |  "
                +p.getPrice() + " -> " + p.getPrice()*1.10)
                .forEach(p -> System.out.println(p));

        productList.stream()
                .filter(p -> p.getPrice() > 20000)
                .map(p -> p.getName()
                + " | İndirimli Fiyat : " + p.getPrice()*0.85)
                .forEach(p -> System.out.println(p));

        productList.stream()
                .sorted((p1,p2) -> Double.compare(p2.getPrice(),p1.getPrice()))
                .forEach(p -> System.out.println(p.getName() + " | " + p.getPrice()));
        productList.stream()
                .map(p-> p.getCategory())
                .distinct()
                .forEach(p->System.out.println(p));

        productList.stream()
               // .sorted((p1,p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .sorted( Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(3)
                .forEach(p -> System.out.println(p.getName() + " | " + p.getPrice()));
/*
Görevin: Fiyatı 15.000 TL'den yüksek ürünlerin yalnızca isimlerini yeni bir List<String> içerisine kaydet.
Beklenen liste:
[macbook, iphone, applewatch, samsung]
 */
        List<String> productNames = productList.stream()
                .filter(p -> p.getPrice()> 15000)
                .map(p-> p.getName())
                .collect(Collectors.toList());
        System.out.println(productNames);

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

    @Override
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
