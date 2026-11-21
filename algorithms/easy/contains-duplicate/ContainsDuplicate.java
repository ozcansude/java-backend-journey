import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums = {19,0,1,20,0,5,3,6,20,0,4,20,26};
        int[] uniqueNums = {12,23,45,56};

        System.out.println("=== Contains Duplicate ===");

        System.out.println("\nInput: " + Arrays.toString(nums));
        System.out.println("Brute Force: " + bruteForce(nums));
        System.out.println("HashSet: " + hashSetSolution(nums));

        System.out.println("\nInput: " + Arrays.toString(uniqueNums));
        System.out.println("Brute Force: " + bruteForce(uniqueNums));
        System.out.println("HashSet: " + hashSetSolution(uniqueNums));
    }
    public static boolean bruteForce(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hashSetSolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
