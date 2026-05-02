# Longest Common Prefix

# Soru

Bir string dizisi veriliyor.

Amaç: Dizideki bütün kelimelerin baştan ortak olan kısmını bulmak.

Örnek:
    ["flower", "flow", "flight"]

Cevap:
    "fl"

Çünkü üç kelime de "fl" ile başlıyor.

Eğer ortak başlangıç yoksa cevap:
    ""

olur.

Örnek:
    ["dog", "racecar", "car"]

Cevap:
    ""

Çünkü kelimelerin başında ortak harf yoktur.

 Ana Mantık

İlk kelimeyi referans alırız.
    String first = strs[0];
Sonra bu kelimenin harflerini tek tek diğer kelimelerle karşılaştırırız.

Mantık şu:
    first'in("flower") 1.indeksi diğerleriyle aynı mı?
    first'in("flower") 1.indeksi diğerleriyle aynı mı?
    first'in("flower") 1.indeksi diğerleriyle aynı mı?

İlk farklılık bulunduğu anda dururuz.

 Kod:

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";

            String first = strs[0];

            for (int i = 0; i < first.length(); i++) {

                char c = first.charAt(i);

                for (int j = 1; j < strs.length; j++) {

                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return first.substring(0, i);
                    }
                }
            }

            return first;
        }
    }

## Kodun Açıklaması
if (strs == null || strs.length == 0)
    return "";
        
Eğer dizi boşsa boş string döndürürüz.
    String first = strs[0];

İlk kelimeyi referans olarak alıyoruz.

Örnek:
    ["flower", "flow", "flight"]

    for (int i = 0; i < first.length(); i++)

İlk kelimenin harflerinde geziyoruz.
(--> first : "flower")

Yani:

    f
    l
    o
    w
    e
    r

    char c = first.charAt(i);

O an kontrol ettiğimiz harfi alıyoruz.

Mesela i = 0 ise:
    c = 'f'

    for (int j = 1; j < strs.length; j++)

Diğer kelimeleri kontrol ediyoruz.

j = 1 ile başlıyoruz çünkü strs[0] zaten bizim referans kelimemiz.

    if (i >= strs[j].length() || strs[j].charAt(i) != c)

Bu satırda iki kontrol var:

1. Diğer kelime daha kısa mı?
2. Diğer kelimedeki harf, referans harfle aynı mı?

Eğer farklılık VARSA ortak prefix burada biter.

    return first.substring(0, i);

Farklılık bulunan yere kadar olan kısmı döndürür.

Örnek:

    first = "flower"
    i = 2

    first.substring(0, 2)

Sonuç:
    "fl"

    return first;

Eğer hiç farklılık bulunmazsa ilk kelimenin tamamı ortak prefix demektir.

Örnek:

    ["flower", "flower"]

Cevap:

    "flower"

---

<> Kısa Özet <>

İlk kelimeyi referans al.
Harf harf diğer kelimelerle karşılaştır.
Fark bulursan:
    return first.substring(0, i);
Hiç fark bulamazsan:
    return first;
