package hashmap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*
Anagram, iki kelimenin aynı harfleri aynı sayıda içermesidir. Harflerin sırası önemli değildir.

Örnek:

listen ve silent → anagram
anagram ve nagaram → anagram
rat ve car → anagram değil
aab ve abb → anagram değil, çünkü harf adetleri farklı

Burada HashMap, her karakterin kaç kez geçtiğini tutmak için kullanılır.
 */
public class ValidAnagram {
    public static void main(String[] args){
        System.out.println(anagramController("Berke","kerbe"));
    }

    public static String anagramController(String s1, String s2){
        char[] k1 = s1.toLowerCase(Locale.ROOT).toCharArray();
        char[] k2 = s2.toLowerCase(Locale.ROOT).toCharArray();

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i = 0 ; i<k1.length; i++){
            if(!map1.containsKey(k1[i])){
                map1.put(k1[i],1);
            }else{
                map1.put(k1[i],map1.get(k1[i]) +1);
            }
        }
        for(int i = 0 ; i < k2.length; i++){
            if(!map2.containsKey(k2[i])){
                map2.put(k2[i],1);
            }else{
                map2.put(k2[i],map2.get(k2[i])+1);
            }
        }
        if(map1.equals(map2)){ // !!! burada == yapmadım çünkü öyle bellekte aynı nesne olup olmadığı kontrol edilir
            return "Kelimeler anagramdır.";
        }
        return "Kelimeler anagram değildir.";

    }

}
