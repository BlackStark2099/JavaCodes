package LeetCode;

public class target_sum_494 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,1};
        System.out.println(findTargetSumWays(arr,0));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i]; 
        }
        if(target > sum) return 0;
        if((sum+target)%2 != 0 ) return 0;
        target = (sum+target)/2;
        if(target < 0) return 0;
        int [][] dp = new int [nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=nums.length;i++){
            for(int k=0;k<=target;k++){
                if(k-nums[i-1]>=0){
                    dp[i][k] = dp[i-1][k] + dp[i-1][k-nums[i-1]];
                }
                else{
                    dp[i][k] = dp[i-1][k];
                }
            }
        }
        return dp[nums.length][target];       
    }
    
}
