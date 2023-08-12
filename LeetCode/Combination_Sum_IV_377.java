package LeetCode;

public class Combination_Sum_IV_377 {
    public static void main(String[] args) {
        int [] arr = new int[]{9};
        System.out.println(combinationSum4(arr,3));
    }

    public static int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<target+1;i++){
            int res = 0;
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    res = res + dp[i-nums[j]]; 
                }
            }
            dp[i] = res;
        }
        

        return dp[target];
    }

    
}
