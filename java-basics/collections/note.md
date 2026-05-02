☀︎ JAVA COLLECTIONS NOTLARI

Bu klasörde Java Collections Framework ile ilgili öğrendiğim konuları ve yaptığım pratikleri tutuyorum.
Collections konusu; liste, set, map, queue ve stack gibi veri yapılarını Java'da hazır sınıflar üzerinden kullanmamızı sağlar.

☀︎☀︎☀︎Neden Java Collections Öğreniyorum?
Algoritma problemlerinde ve backend geliştirmede verileri doğru şekilde saklamak ve işlemek için collection yapıları çok önemlidir.

Özellikle şu konuları öğrenmeyi,bunlar üzerinde pratik yapmayı planlıyorum:

- ArrayList
- LinkedList
- HashSet
- HashMap
- Queue
- Stack / Deque



ArrayList:
ArrayList, elemanları sıralı şekilde tutan ve boyutu dinamik olarak değişebilen bir liste yapısıdır.
Normal arraylerden farklı olarak eleman ekledikçe boyutu otomatik olarak büyüyebilir. 
- Sıralamayı korur.
- Aynı elemandan birden fazla olabilir.
- Index ile elemana erişilebilir.
- Index ile erişim O(1) olduğu için hızlıdır.
- Eleman arama işlemi genelde O(n) sürer.
- Ortadan eleman silme işlemi maliyetli olabilir.

örneğin: 




import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(); // array boyutunu belirlemedik
        
        names.add("Ali"); 
        names.add("Ayşe"); // dinamik ekleme 
        names.add("Mehmet");

        System.out.println(names);
        System.out.println(names.get(0));
        System.out.println(names.size());
    }
}


---------------

LinkedList :

LinkedList, elemanları node yapısıyla birbirine bağlı şekilde tutan bir liste yapısıdır.
ArrayList gibi index mantığıyla kullanılabilir ama arka planda çalışma şekli farklıdır.
- Sıralamayı korur.
- Aynı elemandan birden fazla olabilir.
- Başına ve sonuna eleman eklemek kolaydır.
- Index ile erişim ArrayList'e göre daha yavaştır.
- Queue ve Deque gibi de kullanılabilir.

import java.util.LinkedList;

public class LinkedListBasics {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.addFirst(5);
        numbers.addLast(30);

        System.out.println(numbers);           // [5,10,20,30]

        numbers.removeFirst();
        numbers.removeLast();            
        System.out.println(numbers);      //[10,20]
    }
}
-> Elemanalara erişmek ArrayList'e nazaran daha yavaştır çünkü LinkedList'te bilgisayar listenin başından node'ları saymaya başlar.
Rastgele elemana erişim için time complexity ArrayList'te O(1) iken LinkedList'te O(n) 'dir.
-------------------

## HashSet
HashSet, tekrar eden elemanları TUTMAYAN bir collection yapısıdır.
Bir elemanın daha önce eklenip eklenmediğini kontrol etmek için kullanışlıdır.

- Tekrar eden elemanları tutmaz. !!!
- Duplicate kontrolü için çok kullanışlıdır. 
- Elemanların eklenme sırasını garanti etmez.(dolayısıyla burada index'lerle işimiz yok!!!!!!!!)
- Ortalama ekleme ve arama işlemleri O(1)'dir.

import java.util.HashSet;

public class HashSetBasics {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(10);

        System.out.println(numbers); //[10,20] ya da [20,10] HashSet'lerde elemanların eklenme sırası yok
        System.out.println(numbers.contains(20)); // true
    }
}
---------------------

HashMap (KEY-VALUE)

HashMap, verileri key-value şeklinde tutar.
Bir anahtara karşılık bir değer saklamak istediğimizde kullanılır.
- Key-value mantığıyla çalışır.
- Key değerleri unique olmalıdır.
- Value değerleri tekrar edebilir.
- Elemanların eklenme sırasını garanti etmez.
- Ortalama ekleme, silme ve arama işlemleri O(1)'dir.

import java.util.HashMap;

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("Ali", 80);
        scores.put("Ayşe", 90);
        scores.put("Mehmet", 75);

        System.out.println(scores.get("Ali")); // 80
        System.out.println(scores.containsKey("Ayşe")); // true ("ayse" anahtarı var mı - true)

        scores.remove("Mehmet");
        scores.put("Ali",85); // put metodu aynı zamanda GÜNCELLEME DE YAPAR

        System.out.println(scores); // {Ali = 85 , Ayşe = 90}
    }
}

--------------------------

## Queue

Queue, FIFO mantığıyla çalışır.

FIFO: First In First Out(ilk giren ilk çıkar)
ºMarketetki kasa sırası gibi düşünebiliriz. Sıraya ilk giren kişi ilk çıkan kişi olacaktır.

- Sıralı işlem yapılması gereken durumlarda kullanılır.
- İlk eklenen eleman ilk çıkar.
- BFS algoritmasında sık kullanılır.
- poll() elemanı çıkarır.
- peek() sıradaki elemanı gösterir ama çıkarmaz.
- add() eleman ekler.

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
                                        
        queue.add("First");       
        queue.add("Second");           // "First" --> "Second" --> "Third"
        queue.add("Third");

        System.out.println(queue.poll());  // "First"
        System.out.println(queue.peek()); // "Second"
        System.out.println(queue); // ["Second","Third"]
    }
}

---------------------------------

Stack/Dequeue

Stack, LIFO mantığıyla çalışır.

LIFO: Last In First Out(Son giren ilk çıkar)
--> LIFO'yu üst üste konmuş kitap yığını olarak düşünebiliriz. en son koyduğumuzu ilk almamız gibi son eklenen eleman ilk çıkan eleman olur.

- Son eklenen eleman ilk çıkar.
- Parantez kontrolü problemlerinde kullanılır.
- Geri alma işlemlerinde kullanılabilir.
- `push()` eleman ekler.
- `pop()` son eklenen elemanı çıkarır.
- `peek()` son elemanı gösterir ama çıkarmaz.

import java.util.ArrayDeque;
import java.util.Deque;

public class StackBasics {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10); // stack : [10]
        stack.push(20); // stack : [20,10]
        stack.push(30); // stack : [30,20,10]

        System.out.println(stack.pop()); // 30
        System.out.println(stack.peek()); // 20
        System.out.println(stack); // [10, 20]
    }
}




---

Hangi Collection Ne Zaman Kullanılır?

| Collection | Kullanım Amacı |

| ArrayList | Index ile hızlı erişim gerektiğinde |
| LinkedList | Başta veya sonda sık ekleme-silme yapılacağında |
| HashSet | Tekrar eden elemanları engellemek istediğimizde |
| HashMap | Key-value ilişkisi kurmak istediğimizde |
| Queue | FIFO sırası gerektiğinde |
| Deque | Stack veya çift taraflı queue gerektiğinde |

---------------------------------------------------------------------------------------------------

## Bu Konuda Çözmek İstediğim Problemler

- ArrayList içinde maksimum elemanı bulma
- ArrayList içinden duplicate elemanları silme
- HashSet ile duplicate kontrolü yapma
- HashMap ile kelime frekansı sayma
- HashMap ile karakter frekansı sayma
- Queue ile basit sıra simülasyonu yapma
- Stack ile valid parentheses problemi çözme
- Liste elemanlarını ters çevirme
- İki listeyi birleştirme

---------------------------------------------------------------------------------------------------






