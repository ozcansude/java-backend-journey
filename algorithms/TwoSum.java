package java.com.expense;

import java.util.HashMap;


public class TwoSum {

    public static void bruteForce(int[] array, int target) {
        for(int i=0; i<array.length; i++){ // İç içe iki döngü olduğundan timw comlexity O(n^2)'dir.
            for(int j = i+1; j<array.length; j++){
                if(array[i] + array[j] == target){
                    System.out.println(i + " and "+j +". indices");
                }
            }
        }
    }
    public static void hashMapSolution(int[] array, int target){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< array.length; i++){ // burada tek döngü var time comlexity O(n)
            int current = array[i];
            int needed = target - current; // ihtiyacım olan sayı listede var mı varsa onu yazdırıcam yoksa onu ekleyeceğim.

            if(map.containsKey(needed)){
                System.out.println(map.get(needed) + " and " + i); // O(1)
            }else{
                map.put(current,i); // map.put... O(1)
            }
            // bu yüzden de hashmap çözümünün time comlexity'si O(n)'dir.
        }

    }

    public static void main(String[] args){
        int[] array= new int[]{12,15,17,20,25,35,65};
        int target = 50;

        bruteForce(array,target);
        hashMapSolution(array,target);
    }
}
