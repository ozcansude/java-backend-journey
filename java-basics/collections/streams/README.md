-> Java Stream API Denemesi 
Bu proje, Java'da Stream API kullanarak Collections'ı nasıl daha verimli, temiz ve okunabilir şekilde işleyebileceğimizi göstermek amacıyla oluşturulmuştur.

♧ Bu küçük projeyi kodlarken şu temel Java kavramlarını uyguladım:

OOP : Bir Product sınıfı oluşturup; değişkenleri private tutarak, bunlara Getter/Setter metotlarıyla eriştim.

Method Overriding: Java'nın temel `toString()` metodunu kendi sınıfıma göre özelleştirerek ürün bilgilerini anlamlı bir formatta yazdırdım.

Stream API: Listeler üzerinde for döngüsü kullanmak yerine stream yapısını tercih ettim.
.filter(): Belirli bir fiyat limitinin üzerindeki ürünleri filtreledim.
.forEach(): Kalan objeleri tek tek işleyerek ekrana bastırdım.

Lambda Expressions: (p -> p.getPrice() > 50000) gibi yapılarla kodumu çok daha kısa ve öz yazdım.

*KODUN MANTIĞI*

Elimizde farklı ürünler var ve biz sadece "Pahalı" (50.000₺ üzeri) olanları seçip terminale yazdırıyoruz (toString kullanarak).

```Java
productList.stream()
           .filter(p -> p.getPrice() > 50000)
           .forEach(p -> System.out.println("❖ Expensive Product: " + p.toString()));
```
Dosya Yapısı
Product.java: Ürün şablonum ve özellikleri.
StreamExample.java: Stream işlemlerinin yapıldığı ana (main) sınıf.
