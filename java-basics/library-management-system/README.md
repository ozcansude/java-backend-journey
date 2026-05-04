# Java Kütüphane Sistemi Pratiği

Bu proje Java öğrenirken yaptığım basit bir kütüphane sistemi pratiğidir.

Projede kitapları listeleme, müsait kitapları gösterme, kategoriye göre filtreleme, isme göre sıralama ve kitap ödünç alma işlemleri yapılmaktadır.

## Projenin Amacı

Bu projeyi Java'da öğrendiğim temel konuları pratik etmek için yaptım.

Bu projede özellikle şunları çalıştım:

- Class oluşturma
- Constructor kullanımı
- Getter ve setter metotları
- List kullanımı
- Stream API kullanımı
- filter, map, sorted metotları
- String karşılaştırmada equals kullanımı
- Nesne referansı mantığı


> Kullanılan Teknolojiler
- Java
- Java List
- Java Stream API

> Proje Dosyaları
- Book.java
- LibraryService.java
- Main.java

>> Book.java
Bu sınıf kitap bilgilerini tutar.
Bir kitabın şu bilgileri var:

- id
- title
- author
- category
- available

available değeri kitabın müsait olup olmadığını belirtir.

>> LibraryService.java

Bu sınıf kütüphane işlemlerini yapar.
İçindeki bazı metotlar:

- Tüm kitapları gösterir
- Müsait kitapları gösterir
- Kitap ödünç alır
- Kategoriye göre kitap filtreler
- Kitapları isme göre sıralar

>> Main.java
Bu dosyada örnek kitaplar oluşturulur ve LibraryService içindeki metotlar test edilir.

Özellikler

- Tüm kitapları listeleme
- Müsait kitapları listeleme
- Kitap ödünç alma
- Kategoriye göre kitap arama
- Kitapları başlığa göre sıralama

## Öğrendiğim Önemli Noktalar 

Java'da String karşılaştırırken == kullanmak doğru değildir.

Yanlış kullanım:
book.getCategory() == category

Doğru kullanım:
book.getCategory().equals(category)
Çünkü == metnin içeriğini değil, bellekte aynı nesne olup olmadığını kontrol eder.

Ayrıca yeni Book nesnesi oluşturduğumda listedeki kitabı değiştirmediğimi öğrendim. Bir kitabı ödünç almak için listedeki kitabı id ile bulup onun available değerini değiştirmek gerekir.

## Örnek Kullanım
Program çalışınca kitaplar listelenir, kategoriye göre filtreleme yapılır, kitaplar isme göre sıralanır ve bir kitap ödünç alınır.
Örnek olarak Sofie'nin Dünyası kitabı ödünç alındıktan sonra tekrar ödünç alınmak istenirse kitap mevcut değil mesajı gösterilir.

## Sonuç
Bu proje küçük bir Java pratiğidir. Amacım Java'da class, list, stream ve basit servis mantığını daha iyi anlamaktır.
