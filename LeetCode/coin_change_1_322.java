package LeetCode;

class Solution {
    public int coinChange(int[] coins, int amount) {
       if(amount == 0) return 0;
        int [] dp = new int[amount+1];

        for(int i=0;i<amount+1;i++){
            dp[i] = -1;
        }

        dp[0] = 0;

        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<amount+1;j++){
                if(dp[j]>0){
                    if(dp[j-coins[i]]>-1){
                        dp[j] = Math.min(1 + dp[j-coins[i]],dp[j]);

                    }
                }else{
                    if(dp[j-coins[i]]>-1){
                        dp[j] = 1 + dp[j-coins[i]];
                    }
                }
                
            }
        }

        return dp[amount];
    }
}