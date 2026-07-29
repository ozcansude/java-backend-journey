package hashmap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MapMethodsDemo {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("Bilgisayar",50000);
        map.put("Klavye", 10000);
        map.put("Mouse",5000);

        usingEntrySet(map);
        usingKeySet(map);

        String a = "banana";
        usingGetOrDefault(a);

        //putIfAbsent metodu put gibi ancak ondan farklı olarak var olan key'i yine yazınca value'da güncelleme yamıyo.
        map.putIfAbsent("Bilgisayar", 100000);
        System.out.println(map); // Bilgisayar fiyatı hala 50000.


    }

    public static void usingEntrySet(Map<String,Integer> map){

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() +" ürününün fiyatı : "+entry.getValue());
        }
    }
    public static void usingKeySet(Map<String,Integer> map){
        for(String key : map.keySet()){
            System.out.println(key);
        }
    }
    //bir kelimenin harflerini getOrDefault ile say -> getOrDefault('a', 0) → 0

    public static void usingGetOrDefault(String s){
        Map<Character,Integer> map = new HashMap<>();
        char[] dizi = s.toLowerCase(Locale.ROOT).toCharArray();
        for(int i = 0; i< dizi.length; i++){
            map.put(dizi[i], map.getOrDefault(dizi[i],0)+1);
        }
        System.out.println(map);
    }

}
