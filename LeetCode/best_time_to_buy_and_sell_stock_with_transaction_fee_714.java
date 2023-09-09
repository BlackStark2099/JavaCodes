package LeetCode;

public class best_time_to_buy_and_sell_stock_with_transaction_fee_714 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,3,7,5,10,3};
       
        System.out.println( maxProfit(arr, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int [][] dp = new int [2][prices.length];
        dp[0][0] = 0-prices[0]-fee;
        dp[1][0] = 0;

        for(int i=1;i<prices.length;i++){
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1]-prices[i]-fee);
            dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1]+prices[i]); 
        }
        return Math.max(dp[1][len-1],dp[0][len-1]);
    }
    
}
