# Employee Analytics Exercises

Bu egzersizlerde amaç veri eklemek/silmek değil; mevcut veriyi SQL ile okumak ve analiz etmek.

## Seviye 1 — Temel SELECT

1. Tüm çalışanların adını, soyadını, unvanını ve maaşını listele. + 
2. Sadece aktif çalışanları listele. + 
3. Maaşı 70.000'den yüksek olan çalışanları maaşa göre büyükten küçüğe sırala.
4. En yeni işe başlayan 5 çalışanı listele.
5. 2022-01-01 tarihinden sonra işe başlayan çalışanları bul.
6. Performans skoru 5 olan çalışanları listele.
7. Aktif olmayan çalışanları listele.

## Seviye 2 — JOIN pratiği

8. Her çalışanın adını, soyadını, departman adını ve departman lokasyonunu listele.
9. Her çalışanın adını, soyadını ve manager adını listele. Manager olmayanlarda manager alanı boş gelebilir.
10. Her projenin adını, bağlı olduğu departman adını ve proje durumunu listele.
11. Projelerde çalışan kişileri proje adı, çalışan adı, rol ve haftalık saat bilgisiyle listele.
12. Engineering departmanındaki çalışanları departman adıyla birlikte listele.
13. Istanbul lokasyonundaki departmanlarda çalışan kişileri listele.

## Seviye 3 — Aggregate fonksiyonları

14. Toplam çalışan sayısını bul.
15. Aktif çalışan sayısını ve aktif olmayan çalışan sayısını ayrı ayrı göster.
16. Her departmanda kaç çalışan olduğunu bul.
17. Her departmanın ortalama maaşını hesapla.
18. Her departmandaki en yüksek ve en düşük maaşı göster.
19. Tüm şirketin aylık toplam maaş yükünü hesapla. (toplam maaş yani)
20. Her proje için toplam haftalık çalışma saatini bul.
21. Her proje için kaç farklı çalışanın görev aldığını bul.

## Seviye 4 — GROUP BY + HAVING

22. Ortalama maaşı 70.000'den yüksek olan departmanları listele.
23. En az 5 çalışanı olan departmanları listele.
24. Toplam haftalık çalışma saati 40'tan fazla olan projeleri listele.
25. Birden fazla projede çalışan kişileri bul.
26. En az 3 kişiyi yöneten manager'ları listele.
27. Toplam proje bütçesi 100.000'den fazla olan departmanları listele.

## Seviye 5 — Biraz daha gerçekçi analizler

28. Her çalışanın toplam haftalık proje saatini göster. Projesi olmayan çalışanlar da listede görünsün.
29. Hiçbir projeye atanmamış çalışanları bul.
30. En çok çalışanı olan projeyi bul.
31. En yüksek toplam haftalık çalışma saatine sahip ilk 5 çalışanı listele.
32. Aktif projelerde çalışan kişileri departmanlarıyla birlikte listele.
33. Her departmanın yıllık bütçesini ve çalışan maaşlarının toplamını yan yana göster.
34. Departman bütçesinin maaş toplamından büyük olup olmadığını gösteren bir sonuç üret.
35. Aktif projelerdeki ortalama çalışan maaşını proje bazında hesapla.

## Bonus

36. Çalışanları maaş aralığına göre sınıflandır:
    - 50.000 altı: `low`
    - 50.000 - 80.000 arası: `mid`
    - 80.000 üstü: `high`
37. Her departmanda kaç farklı unvan olduğunu bul.
38. Maaşı kendi departman ortalamasından yüksek olan çalışanları listele.
39. 2024 yılında başlayan projeleri listele.
40. Manager'ı olmayan çalışanları yani üst yöneticileri listele.