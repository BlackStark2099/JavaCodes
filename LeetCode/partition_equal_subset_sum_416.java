package LeetCode;

public class partition_equal_subset_sum_416 {
    public static void main(String[] args) {
        int [] arr = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i]; 
        }
        System.out.println("sum = "+sum);
        if(sum%2 != 0 ) return false;
        int target = (sum)/2;     
        long [][] dp = new long [nums.length+1][(target+1)];
        for(int i=0;i<=nums.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=nums.length;i++){
            for(int k=0;k<=target;k++){
                if(nums[i-1]>k){
                    dp[i][k] = dp[i-1][k];
                }
                else{
                    dp[i][k] = dp[i-1][k] + dp[i-1][k-nums[i-1]];
                }
            }
        }
        System.out.println(dp[nums.length][target]);
        if( dp[nums.length][target] != 0){
            return true;
        }else{
            return false;
        }

    }
}
