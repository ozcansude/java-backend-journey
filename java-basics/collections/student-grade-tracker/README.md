Student Ranking System 

Bu proje, Java OOP ve Java Stream API konularını pratik etmek için geliştirdiğim başlangıç seviyesinde bir öğrenci sıralama sistemidir.

PROJE ÖZELLİKLERİ
1- Öğrenci nesneleri oluşturma
2- Öğrenci not ortalaması hesaplama
3- Ortalaması 70 ve üzeri olan öğrencileri filtreleme
4- Öğrencileri not ortalamasına göre sıralama
5- Ortalama eşitse bölüme göre sıralama
6- İlk 3 öğrenciyi listeleme


Stream API İçerisinde Kullandıklarım
1. stream()
students.stream()

Öğrenci listesini stream yapısına çevirerek işlemler yapmamı sağlar.
-
2. filter()
.filter(student -> student.getGrade() >= 70)

Not ortalaması 70 ve üzeri olan öğrencileri seçer.

Yani başarısız öğrenciler listeden çıkarılır.
-
3. sorted()
.sorted(
    Comparator.comparing(Student::getGrade).reversed()
    .thenComparing(Student::getDepartment)
)

Öğrencileri sıralamak için kullandım.

Sıralama Mantığı:
Önce not ortalamasına göre (büyükten küçüğe)
Eğer ortalama eşitse bölüm adına göre alfabetik sıralama

4. collect()
.collect(Collectors.toList())

Stream sonucu oluşan veriyi tekrar List haline getirir.
--------------------------------------------------------------------------------------------------------------------
🔺 Neden Math.min(3, regulatedList.size()) Kullandım?
for(int i = 0; i < Math.min(3, regulatedList.size()); i++)

Programda ilk 3 öğrenciyi göstermek istedim.

Fakat filtreleme işleminden sonra bazen listede 3 öğrenci olmayabilir.

Örneğin:

Sadece 2 öğrenci geçtiyse
Eğer direkt i < 3 yazarsam program hata verir.
Oluşabilecek hata:
IndexOutOfBoundsException

Çünkü olmayan index'e ulaşmaya çalışır.

Çözüm:
Math.min(3, regulatedList.size())

Bu ifade:

Liste 5 kişiyse → 3 döner
Liste 2 kişiyse → 2 döner

Yani küçük olan değeri alır.

Böylece program güvenli şekilde çalışır ve hata vermez.
--------------------------------------------------------------------------------------------------------------------
 Örnek Çıktı
top 3 students for grade

1. student Rabos --> grade : 80
2. student Sude --> grade : 80
3. student Berke --> grade : 76
 
💕 Bu Projede Öğrendiklerim
Java Stream API kullanımı
filter() ile veri süzme
sorted() ile sıralama
Comparator kullanımı
collect() ile listeye çevirme
OOP mantığı
Runtime hatalarını önleme !!! 
Daha temiz kod yazımı



