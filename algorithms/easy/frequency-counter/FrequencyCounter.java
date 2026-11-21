import java.util.HashMap;

public class FrequencyCounter {
    public static void main(String[] args){
        int[] sayilar = {2, 5, 2, 8, 5, 2};
        frequencyCounter(sayilar);
    }
    static void frequencyCounter(int[] array){
        HashMap<Integer,Integer> integerMap = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            if(!integerMap.containsKey(array[i])){
                integerMap.put(array[i], 1);
            }else{
                int currentCount = integerMap.get(array[i]);
                integerMap.put(array[i], currentCount+1);
            }

        }
        integerMap.forEach((key,value) -> {
            System.out.println(key + " -> " + value);
        });

        int maxCount = 0;
        int mostFrequent = 0;
        for(var entry : integerMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        System.out.println("Most frequently repeated number : "+mostFrequent+"\nFrequency: "+maxCount);
    }
}
