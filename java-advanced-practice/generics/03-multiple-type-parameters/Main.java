
public class Main {
    public static void main(String[] args){

        Pair<String, Integer> urun = new Pair<>("Laptop",35000);

        String isim = urun.getKey();
        Integer fiyat = urun.getValue();

        System.out.println("Ürün ismi : "+ isim);
        System.out.println("Ürün fiyatı : "+ fiyat);

    }
}
