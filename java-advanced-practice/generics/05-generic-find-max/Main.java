
public class Main {
    public static void main(String[] args){

        Integer[] sayilar = {4,18,7,32,11};
        Double[] doubles = {2.5,9.8,1.3};
        String[] strings = {"Zeynep","Ali","Mehmet"}; // zeynep
        Integer[] sayilar1 = {-10,-3,-25}; // -3
        Integer[] numbers = {43};
        Integer[] bos = {};
        Integer[] list1 = null;

        System.out.println(GenericMaxFinder.findMax(sayilar));      // 32
        System.out.println(GenericMaxFinder.findMax(doubles));      // 9.8
        System.out.println(GenericMaxFinder.findMax(strings));      // Zeynep
        System.out.println(GenericMaxFinder.findMax(sayilar1));     // -3
        System.out.println(GenericMaxFinder.findMax(numbers));      // 43
    //    System.out.println(GenericMaxFinder.findMax(bos));          // IllegalArgumentException
        System.out.println(list1);                                  // null

        Urun[] urunler = {
                new Urun("Laptop", 35000),
                new Urun("Telefon", 25000),
                new Urun("Monitör", 12000),
                new Urun("Klavye", 4000),
                };

        System.out.println(GenericMaxFinder.findMax(urunler));

    }
}
