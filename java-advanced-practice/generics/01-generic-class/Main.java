
/*
Kutu<String> nesnesi oluştur. İlk değeri "Java" olsun.

getVeri() metoduyla içindeki değeri ekrana yazdır.

setVeri() metoduyla değeri "Generics" olarak değiştir.

Yeni değeri tekrar ekrana yazdır.

Ardından Kutu<Integer> nesnesi oluştur. İçine 100 koy ve ekrana yazdır.
 */

public class Main {
    public static void main(String[] args){
        Kutu<String> kutu = new Kutu<>("Java");
        System.out.println(kutu.getVeri());

        kutu.setVeri("Generics");
        System.out.println(kutu.getVeri());

        Kutu<Integer> sayi = new Kutu<>(100);
        System.out.println(sayi.getVeri());

    }
}
