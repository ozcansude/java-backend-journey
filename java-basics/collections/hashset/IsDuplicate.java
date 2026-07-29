package hashset;

import java.util.HashSet;

public class IsDuplicate {
    public static void main(String[] args){
        String[] names = {"sude", "berke", "iklima", "dicle", "berke"};

        System.out.println(isDuplicate(names));
    }
    // time complexity : O(n), space complexity : O(n)
    public static boolean isDuplicate(String[] arr){
        HashSet<String> set = new HashSet<>();
        for(String a : arr){
            if(!set.add(a)){
                return true;
            }
        }
        return false;
    }
}
