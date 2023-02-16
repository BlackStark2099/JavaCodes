package LeetCode;

class Solution {
    public int change(int amt, int[] coins) {
        int [] dp = new int[amt+1];
        int n = coins.length;
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<amt+1;j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[amt];
    }
}