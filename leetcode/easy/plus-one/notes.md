# Plus One
## Problem

Verilen `digits` array'i bir sayının basamaklarını temsil eder.

Ornek:
[1, 2, 3] -> 123

Amac, bu sayiya `1` ekleyip sonucu tekrar array olarak döndürmektir.

## Örnekler

~~~
Input:  [1,2,3]
Output: [1,2,4]

Input:  [1,9,9]
Output: [2,0,0]

Input:  [9,9,9]
Output: [1,0,0,0]
~~~

## İlk Yaklaşımım

Başta sağdan sola gidip, eğer basamak `9` ise onu `0` yapıp soldaki basamağı artırmayı düşündüm.


if (digits[i] == 9) {
    digits[i] = 0;
    digits[i - 1]++;
}

Bu fikir carry mantığına benziyor. Ancak bazı durumlarda hatalı sonuç üretiyor.

## Yaptığım Hata

Benim ilk kodumda `digits[i] = 0` yaptıktan sonra aynı basamak tekrar kontrol ediliyordu.

~~~
if (digits[i] < 9) {
    digits[i]++;
}
~~~

Yani basamak `9` ise önce `0` yapılıyor, sonra tekrar `1` artırılabiliyordu.

Örneğin:
[1,9,9]


Son basamak için:
9 -> 0 -> 1

Bu yüzden sonuçlar yanlış olabiliyordu.

Ayrıca şu işlem de güvenli değildir:

digits[i - 1]++;


---> Çünkü soldaki basamak da `9` olabilir. Bu durumda basamak `10` olur ve array mantığı bozulur.

Örneğin yanlış bir sonuç:
[1,9,9] -> [1,10,1]


## Doğru Mantık

Sağdan sola doğru ilerlenir.

- Eğer basamak `9` değilse, `1` artırılır ve array döndürülür.
- Eğer basamak `9` ise, `0` yapılır ve sola devam edilir.
+
- Eğer tüm basamaklar `9` ise, yeni bir array oluşturulur.
- Yeni array'in ilk elemanı `1` olur.
+
## Çözüm

~~~java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}


## Zaman ve Alan Karmaşıklığı


Time Complexity: O(n)
Space Complexity: O(1)


Not: Eğer tüm basamaklar `9` ise yeni array oluşturulduğu için bu özel durumda alan kullanımı `O(n)` olur.

## Öğrendiklerim

- Carry işlemini doğrudan `digits[i - 1]++` ile yapmak her zaman güvenli değildir. !!!
- `if` ve `else` farkına dikkat etmek gerekir.
- `return` doğru yerde kullanılmalıdır.
- Tüm basamaklar `9` olduğunda array boyutu büyümelidir. !!!
