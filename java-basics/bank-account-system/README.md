# Bank Account App

Bu proje Java ile yazılmış basit bir banka hesabı uygulamasıdır.  
Amaç; class, constructor, getter-setter, List kullanımı ve temel servis mantığını pratik etmektir.

## Proje Hakkında

Uygulamada bir banka hesabı oluşturulur ve bu hesap üzerinde bazı işlemler yapılır.

- Para yatırma
- Para çekme
- Bakiye gösterme
- İşlem geçmişini görüntüleme

Her para yatırma veya para çekme işleminden sonra işlem geçmişine kayıt eklenir.

## Kullanılan Yapılar

Bu projede temel olarak şu Java konuları kullanıldı:

- Class yapısı
- Constructor
- Getter ve Setter metotları
- Encapsulation
- ArrayList
- List kullanımı
- Service class mantığı
- Basit if/else kontrolleri

## Dosyalar

### Account.java

Hesap bilgilerini tutan class'tır.

İçinde şu bilgiler bulunur:

- id
- ownerName
- balance
- transactions

`transactions` listesi hesabın işlem geçmişini tutacak.

### BankService.java

Banka işlemlerinin yapıldığı class'tır.

İçindeki metotlar:

- deposit() : Para yatırma işlemi.
- withdraw() : Para çekme işlemi.
- showBalance() : Mevcut bakiyeyi gösterir.
- showTransactions() : İşlem geçmişini gösterir.

### Main.java

Programı burda çalışırız.

Burada bir Account nesnesi oluşturulur ve BankService üzerinden işlemler test edilir.

## Burada Neler Öğrendim?

Bu projede transactions gibi başlangıçta kullanıcıdan değer alması gerekmeyen bir listenin nasıl kullanılacağını öğrendim.

`transactions` listesini constructor parametresine eklemedim. Çünkü yeni bir hesap oluştururken işlem geçmişini kullanıcıdan istememe gerek yok. Yeni açılan bir hesabın işlem geçmişi başlangıçta boş olmalıdır.

Bu yüzden `Account` constructor içinde şu şekilde boş bir liste oluşturdum:

```java
this.transactions = new ArrayList<>();


