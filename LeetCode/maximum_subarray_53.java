package LeetCode;

public class maximum_subarray_53 {
    public static void main(String[] args) {
        int [] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(arr);
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(dp[i-1]+nums[i] < nums[i]){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];   
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
