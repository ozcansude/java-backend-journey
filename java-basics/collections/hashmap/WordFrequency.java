package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args){
    String[] meyveler = {"erik","çilek","muz","çilek","kivi","çilek","erik"};

    System.out.println(frequencyCalculator(meyveler));

    }


    public static Map<String, Integer> frequencyCalculator(String[] meyveler){ // buranın parametresi mainde yazdığımız array olacak
        Map<String,Integer> map = new HashMap<>();
        for(String m : meyveler){
            map.put(m,map.getOrDefault(m,0)+1); // burada m map içinde yoksa default 0 kabul edilip 1 tane oluştuğu için +1
        }
        return map;
    }

}
