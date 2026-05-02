package collections.hashset;

import java.util.HashSet;

public class IsDuplicate {
    public static void main(String[] args){
        String[] names = {"sude", "berke", "iklima", "dicle", "berke"};

        isDuplicate(names);
    }

    public static boolean isDuplicate(String[] arr){
        HashSet<String> set = new HashSet<>();
        for(String a : arr){
            if(!set.add(a)){
                System.out.println(a+ " is duplicated!");
                return true;
            }
        }
        return false;
    }
}
