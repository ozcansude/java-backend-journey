# Remove Element - Java Solution

☆Verilen bi dizideki 'val' değerini(değerlerini) silmemiz ve geriye kalan elemanların sayısını('k') bulup bu sayıyı return edeceğiz.

KOD MANTIĞI : 
☆Burada yeni bir array oluşturmak yerine mevuct dizi üzerinde işlemler yapacağız.

bir sayaç tut: 'k' değişkeni oluşturduk bu bizim sayacımız.
döngü oluşturduk : döngü üzerinde gezerek kontrol etme işlemi
şart kontrolü : 
  ♥︎ sums arrayimizde bulunduğumuz indexteki eleman 'val' değerimize eşit değilse onu o anki 'k' değerindeki index'e gönderiyoruz
  (buradaki amacımız 'val'a eşit olanları sona almak)
  ♥︎ Aynı zamanda burda 'k' yı (val değerimize eşit olmadğında)her döngüde artırıyoruzki sayaç görevinde de kullanmış oluyoruz.
  ♥︎ SONUÇ : Döngü bittiğinde 'k' bize yeni uzunluğu verir.
  
 ☃︎ Neden Yeni Dizi Oluşturmadık?
- Bellek kullanımını minimumda tutmak (O(1) Space Complexity) için.

- KOD YAPISI :
public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
