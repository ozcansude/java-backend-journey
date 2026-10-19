# 🎬 Film Lab — PostgreSQL Pratik Görevleri

Önce `film_veritabani.sql` dosyasını çalıştır. Tüm tablolar `film_lab` şemasında. `SET search_path TO film_lab, public;` kullanabilirsin.

**Veri yapısı:** 1.500 film, 900 kişi, 5.000 kullanıcı, 60.000 puan, 25.000 kiralama. Gerçek film başlıkları (ilk 20) hariç bütün örnek kayıtlar ve finansal değerler eğitim amacıyla sentetiktir.

## Seviye 1 — SELECT, filtreleme, toplulaştırma
1. 2010 sonrası yayınlanan 120 dakikadan uzun filmleri getir.
2. Bütçesi 100 milyon USD üzerinde, hasılatı boş olmayan filmleri sırala.
3. Ülkelere göre film sayılarını bul; en az 50 filmi olan ülkeleri göster.
4. `NULL` hasılat bilgisi olan filmleri say ve tüm filmlere oranını hesapla.
5. Her yaş sınıflandırmasının ortalama süresini bul.
6. Her yıl gösterime giren film sayısını hesapla.

## Seviye 2 — JOIN (çok tablo)
7. Film adı, stüdyo, stüdyonun ülkesi ve filmin orijinal dilini tek tabloda göster.
8. Her filmin türlerini tek satırda `STRING_AGG` ile listele.
9. Oyuncu isimleri, karakterleri, film adları ve gösterim yıllarını getir.
10. Yönetmen adı, film adı ve filmin ortalama kullanıcı puanını getir.
11. Yönetmen başına çekilen film sayısını göster; 5'ten fazla filmi olanları bul.
12. Hangi aktörlerin iki farklı türde en çok filme çıktığını bul (`COUNT(DISTINCT ...)`).
13. Hiç yorum yazmamış, ancak puan vermiş kullanıcıları bul.
14. Puanlaması olmayan filmleri `LEFT JOIN` ile bul.
15. Hem izleme listesine eklediği hem puan verdiği filmler bulunan kullanıcıları getir.
16. Oyuncu + yönetmen + tür + stüdyo bilgilerini tek sorguda birleştir (tekrarlı satır problemine dikkat).

## Seviye 3 — GROUP BY, HAVING, alt sorgular
17. En az 15 puanı olan filmlerin ortalama puanına göre ilk 20’sini bul.
18. Tür başına ortalama film bütçesi ve ortalama hasılatı hesapla.
19. Kendi ülkesinde üretilen filmlere ortalamanın üzerinde puan veren kullanıcıları bul.
20. Her stüdyonun en çok gelir elde eden filmini bul.
21. Ortalamadan yüksek hasılat yapan filmleri, aynı yıl çıkan diğer filmlerle karşılaştır.
22. Birden fazla filmde beraber oynayan oyuncu çiftlerini tespit et (self JOIN).
23. En az 3 farklı türde rol almış oyuncuları getir.
24. Hiç ödül adaylığı olmayan ama yüksek kullanıcı puanı alan filmleri bul.

