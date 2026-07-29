package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Bir metindeki kelimelerin kaç kez geçtiğini Map<String, Integer> ile hesaplayan WordFrequencyCounter sınıfı oluştur.

public class WordFrequencyCounter {
    public static void main(String[] args){

        String metin = "merhaba dünya ben sude. sude yazılım öğrenmek istiyor. merhaba sude";
        System.out.println(frequencyCounter(metin));

    }


    public static Map<String,Integer> frequencyCounter(String metin){
        metin = metin.replaceAll("\\p{P}", " "); // !!! bütün noktaları boşlukla değiştik
        String[] metinDizisi = metin.trim().split("\\s+"); // split("\\s+") : yan yana birden fazla boşluğu tek ayırıcı olarak kabul eder.

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < metinDizisi.length; i++){

            if(!map.containsKey(metinDizisi[i])){
                int sayac = 1;
                map.put(metinDizisi[i],sayac);
            }else{
                 map.put(metinDizisi[i] ,map.get(metinDizisi[i]) + 1);
            }

        }

        return map;
    }


}
