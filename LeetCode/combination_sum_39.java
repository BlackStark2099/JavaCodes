package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class combination_sum_39 {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        // Create an array to store the combinations for different target values
        List<List<Integer>>[] tList = new ArrayList[target + 1];
        
        // Initialize the array with empty lists for the base case
        for (int i = 0; i <= target; i++) {
            tList[i] = new ArrayList<>();
        }
        
        // There's one way to achieve a target of 0, which is an empty list
        tList[0].add(new ArrayList<>());

        // Iterate through the coin denominations
        for (int i = 0; i < nums.length; i++) {
            // Iterate through the target values
            for (int j = 1; j <= target; j++) {
                // If the current coin denomination can be used to reach the current target value
                if (j - nums[i] >= 0) {
                    // Copy combinations from previous step and add the current coin denomination
                    List<List<Integer>> temp = tList[j - nums[i]];
                    for (int k = 0; k < temp.size(); k++) {
                        ArrayList<Integer> temp2 = new ArrayList<>(temp.get(k));
                        temp2.add(nums[i]);
                        tList[j].add(temp2);
                    }
                }
            }
        }

        // Return the list of combinations that sum up to the target value
        return tList[target];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(nums, target);
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}
