# Climbing Stairs

## Problem

Bir merdivenin en üstüne çıkmak için `n` basamak vardır.
Her seferinde yalnızca `1` veya `2` basamak çıkılabilir.
Amaç, merdivenin en üstüne kaç farklı şekilde çıkılabileceğini bulmaktır.

~~~~~~~~~~~~~~~
Input: n = 1
Output: 1

Açıklama:
1

~~~~~~~~~~~~~~~
Input: n = 2
Output: 2


Açıklama:
1 + 1
2


## Çözüm Mantığı

Bu problem Fibonacci mantığına benzer.

Bir basamağa ulaşmak için iki farklı yol vardır:

☆1. Bir önceki basamaktan `1` adım çıkmak
☆2. İki önceki basamaktan `2` adım çıkmak

Bu yüzden formül şu şekildedir:


f(n) = f(n - 1) + f(n - 2)


f(3) = f(2) + f(1) = 2 + 1 = 3
f(4) = f(3) + f(2) = 3 + 2 = 5
f(5) = f(4) + f(3) = 5 + 3 = 8



Bu çözümde sadece son iki değer tutulur:


int a = 1; // küçük eleman
int b = 2; // büyük eleman

Daha sonra `3`ten `n`e kadar döngü kurulur.

Her adımda yeni değer şu şekilde hesaplanır:

int temp = a + b;
a = b;
b = temp;


-> Time Complexity
O(n)
çünkü tek bir döngü çalıştırdık


## Not
Bu problem dinamik programlama mantığıyla çözülebilir.
