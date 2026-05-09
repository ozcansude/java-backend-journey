# PostgreSQL Movie Practice

Bu klasörde PostgreSQL öğrenirken yaptığım SQL çalışmalarını tutacağım.

Şimdilik küçük bir film listesi üzerinden çalışacağım.  
Amacım SQL komutlarını ezberlemekten çok, yazarak ve deneyerek öğrenmek.

## Ne yapacağım?

20 tane filmden oluşan basit bir tablo oluşturacağım.

Film tablosunda şimdilik şu bilgiler olacak:

- id
- title
- year
- director

Bu bilgiler üzerinden SQL komutlarını deneyeceğim.

## Öğrenmek istediğim konular

Bu çalışmada özellikle şunları öğrenmeye çalışacağım:

- tablo oluşturma
- tabloya veri ekleme
- verileri listeleme
- belirli şartlara göre veri arama
- filmleri yıla göre sıralama
- yönetmene göre arama yapma
- film adı içinde kelime arama
- veri güncelleme
- veri silme
- kaç tane film olduğunu sayma
- aynı yönetmenden kaç film var bakma
- yönetmenleri yazdırma(duplicate yapmadan!)

## Kullanacağım dosyalar

Bu çalışmayı birkaç dosyaya ayırmayı düşünüyorum.

schema.sql  
Tabloyu oluşturduğum dosya olacak.

insert_movies.sql  
Film verilerini eklediğim dosya olacak.

queries.sql  
Denediğim SQL sorgularını yazacağım dosya olacak.

exercises.md  
Kendim için küçük pratik soruları yazacağım dosya olacak.

## Şimdilik planım

İlk olarak movies adında bir tablo oluşturacağım.

Sonra içine 20 tane film ekleyeceğim.

Daha sonra bu filmler üzerinde sorgular yazacağım.

Örneğin:

- bütün filmleri listele
- 2000 yılından sonra çıkan filmleri getir
- belirli bir yönetmenin filmlerini getir
- filmleri eskiden yeniye sırala
- filmleri yeniden eskiye sırala
- adında belirli bir kelime geçen filmi bul
- bir filmin yılını güncelle
- bir filmi sil
- toplam film sayısını bul

## Neden bu çalışmayı yapıyorum?

⭐️PostgreSQL ve SQL konularını yeni öğreniyorum.  
Bu yüzden küçük ve anlaşılır bir örnek üzerinden ilerlemek istedim.
⭐️Film tablosu basit olduğu için komutları daha rahat deneyebilirim.  
İlerledikçe tabloya yeni alanlar ekleyebilirim.
Ama başlangıç için sadece id, title, year ve director kullanacağım. :)

## Not

Bu çalışma tamamen öğrenme amaçlıdır.  
Bazı sorgular basit olabilir çünkü amacım temel SQL mantığını oturtmak.
