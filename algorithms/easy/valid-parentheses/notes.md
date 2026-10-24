# Parantez Eşleşmesi Sorusu (Stack Öğreniyorum)

Bu soruda amacım, dize içindeki `()`, `[]` ve `{}` işaretlerinin doğru kapatılıp kapatılmadığını bulmak. İlk başta "baştakiyle sondaki bir mi?" diye düşündüm (palindrom mantığı) ama `()[]{}` gibi yan yana durumlarda o mantık patlıyor. O yüzden **Stack (Yığın)** kullanmayı öğrendim.

# Mantık:
- Bir açılış parantezi (`(`, `{`, `[`) gördüğümde onu bir kenara (yığına) atıyorum.
- Bir kapanış parantezi gördüğümde ise yığının top'ına bakıyorum.
- Eğer elimdeki kapanışla, yığının tepesindeki açılış birbirine uygunsa, o parantezi yığından çöpe atıyorum.
- En son elimde hiçbir şey kalmadıysa (yığın boşsa), true döndürdum.

# Java'da Neler Öğrendim?
- Stack<Character>: Karakterleri üst üste dizdiğim kutu. -- most
- push(): Kutunun en üstüne bir karakter fırlatır.
- pop(): En üstteki karakteri çekip alır (kapanış gelince kontrol için kullanıyoruz).
- isEmpty(): Kutu boş mu diye bakar. Eğer dize bitmeden kutu boşalmışsa veya dize bitince hala içinde bir şey varsa bir şeyler yanlış gitmiş demektir.

# Özet
1. String uzunluğu tekse zaten eşleşemezler, direkt `false` döndür.
2. `for` döngüsüyle her karaktere tek tek bak.
3. Açılış paranteziyse `push` yap.
4. Kapanışsa `pop` ile son açılanı çıkar ve eşleşiyorlar mı kontrol et.
5. En son `stack.isEmpty()` ise `true` dön.

**Not:** Bu soru bana neden dizi yerine Stack kullanmam gerektiğini çok iyi öğretti. Sıralı ve iç içe işlerde Stack hayat kurtarıyormuş
