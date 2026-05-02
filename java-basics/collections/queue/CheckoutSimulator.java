package collections.queue;

import java.util.*;
//döngümü 20 dk boyunca yaptık 20 dk sonunda sırada kaç kişi var bunu göstereceğiz.
//rastgele sayı üretip sayının tuttuğu durumda yeni müşeri ekliyoruz.
// eğer random sayımız 3'ten küçükse queueya yeni müşteri ekle
//Eğer kasa boşsa ve kuyrukta bekleyen varsa kuyruktan birini al ve ona bir işlem süresi ata
//işlemi devam eden müşterinin süresini her dk 1 azalt.
// Her dk sonunda kaç kişi kaldığını ekrana yazdır.
public class CheckoutSimulator {
    public static void main(String[] args){
        // Javada Queue bir interface'tir yani doğrudan newlenemez!!!
        Queue<String> sira = new LinkedList<>();


        sira.offer("Müşteri 1");
        sira.offer("Müşteri 2");
        sira.offer("Müşteri 3");

        int toplamMusteriSayisi = checkoutQueue(sira);


        System.out.println("Simülasyon bitti.");
        System.out.println("Toplam gelen müşteri sayısı: " + toplamMusteriSayisi);
        System.out.println("20 dakika sonunda sırada kalanlar: " + sira);
        System.out.println("20 dakika sonunda sırada bekleyen kişi sayısı: " + sira.size());


    }
    public static int checkoutQueue(Queue<String> kuyruk){
        int kasaIslemSuresi = 0; // kasanın boş olduğu anlamına gelir
        Random random = new Random();
        int customerCounter = kuyruk.size(); // başlangıçta 3 müşteri var
        String aktifMusteri = null;

        for(int dk = 1; dk <= 20 ; dk++){
            if(random.nextInt(10) < 3){
                customerCounter++;

                String yeniMusteri = "Müşteri " + customerCounter;
                kuyruk.offer(yeniMusteri);

                System.out.println(dk+". dakikada " +yeniMusteri+ " eklendi. :)");
            }

            if(kasaIslemSuresi == 0 && !kuyruk.isEmpty()){
                aktifMusteri = kuyruk.poll();
                System.out.println(aktifMusteri + " kasaya geçti.");

                kasaIslemSuresi = random.nextInt(5) + 1;
                System.out.println("Müşterinin işlem süresi: " + kasaIslemSuresi + " dakika");

            }

            if(kasaIslemSuresi > 0){
                kasaIslemSuresi--;
                if (kasaIslemSuresi == 0) {
                    System.out.println(aktifMusteri + " işlemini bitirdi ve ayrıldı.");
                    aktifMusteri = null;
                }
            }
            System.out.println(dk+". dk'da sırada olan müşteri sayısı "+ kuyruk.size());

        }

        return customerCounter;
    }
    // !!! queue'de add yerine genellikle offer tercih edilir --> çünkü kuyruğa ekleyemezse add exception fırlatır, offer ise false döndürür.

}
