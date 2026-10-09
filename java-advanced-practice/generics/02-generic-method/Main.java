
/*
yazdir() metoduyla "Merhaba" ve 2026 değerlerini ekrana yazdır.

Yardimci nesnesi oluştur.

Bu nesne üzerinden aynisiniDondur() metoduna "Java" gönder ve sonucu bir String değişkenine ata.

Aynı metoda 99 gönder ve sonucu bir Integer değişkenine ata.

Son iki değişkeni de ekrana yazdır.
 */


public class Main {
    public static void main(String[] args){

        Yardimci.yazdir("Merhaba");

        Yardimci.yazdir(2026);

        Yardimci yardimci = new Yardimci();

        String veri = yardimci.aynisiniDondur("Java");

        Integer sayi = yardimci.aynisiniDondur(34);

        System.out.println(veri);
        System.out.println(sayi);
    }
}
