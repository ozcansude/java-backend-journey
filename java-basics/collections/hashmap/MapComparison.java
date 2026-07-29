package hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapComparison {
    public static void main(String[] args){

        //testHashMap();
        //testLinkedHashMap();
        testTreeMap();
    }
    public static void testHashMap(){
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Java",90);
        hashMap.put("Spring",60);
        hashMap.put("PostgreSQL",80);
        hashMap.put("Python",70);
        hashMap.put("AI",50);

        hashMap.put("AI",55); // key unique'tir. tekrarlanırsa value güncellenir.

        System.out.println(hashMap);

        System.out.println(hashMap.get("Java"));
        System.out.println(hashMap.get("C#"));

        System.out.println("AI Listede var mı : "+hashMap.containsKey("AI"));

        System.out.println("65 değeri listede var mı? : "+ hashMap.containsValue(65));
        System.out.println("55 değeri listede var mı? : "+ hashMap.containsValue(55));

        hashMap.remove("AI"); // AI'ı listeden sildik.

        System.out.println(hashMap);

        //System.out.println(hashMap.remove("Python")); // bu silinen value'yü (70) döndürür

        System.out.println("EntrySet ile dolaşma : ");
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey()+ "  ->  "+entry.getValue());
        }

        System.out.println("---------------------");

        System.out.println("keySet ile dolaşma : ");
        for(String key : hashMap.keySet()){
            int value = hashMap.get(key);
            System.out.println(key + "  ->  "+value);
        }

        System.out.println("---------------------");

        System.out.println("values ile dolaşmak : ");

        for(int value : hashMap.values()){
            System.out.println(value);
        }

    }
    public static void testLinkedHashMap(){
        Map<String, Integer> linked = new LinkedHashMap<>();

        linked.put("Java",90);
        linked.put("Spring",60);
        linked.put("PostgreSQL", 80);
        linked.put("Python", 70);
        linked.put("AI", 50);

        linked.put("AI", 55);

        System.out.println(linked);

        System.out.println(linked.get("Spring"));
        System.out.println(linked.get("Docker"));

        System.out.println("AI listede var mı? : "+ linked.containsKey("AI")); // AI listede var mı
        System.out.println("C# listede var mı? : "+ linked.containsKey("C#")); // C# listede var mı

        System.out.println(linked.containsValue(65));

        linked.remove("Python");

        linked.put("Python",75);

        System.out.println(linked);

        System.out.println("----------------------");
        System.out.println("EntrySet ile dolaşma : ");
        for(Map.Entry<String,Integer> entry : linked.entrySet()){
            System.out.println(entry.getKey() +"  ->  "+ entry.getValue());
        }



    }

    public static void testTreeMap(){
        Map<String,Integer> treeMap = new TreeMap<>();

        treeMap.put("Java",90);     // DİKKAATT
        treeMap.put("Spring", 60); // ALFABETİK SIRALAMA !!!
        treeMap.put("PostgreSQL",80);
        treeMap.put("Python",70);
        treeMap.put("AI",50);

        System.out.println(treeMap);

        //treeMap.remove("Python");

        System.out.println("----------------------");
        System.out.println("entrySet ile dolaşma : ");
        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() +"  ->  "+entry.getValue());
        }
        treeMap.put("Python",65);
        System.out.println(treeMap);

    }
}
