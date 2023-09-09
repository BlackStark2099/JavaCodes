package LeetCode;

import java.util.ArrayList;

public class best_Time_to_buy_and_sell_stock_II_122 {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,0,2};
        maxProfit(arr);
    }
     public static int maxProfit(int[] prices) {
        int len  = prices.length;
        ArrayList<Integer>  buy = new ArrayList<Integer>();
        ArrayList<Integer>  sell = new ArrayList<Integer>();
        Boolean buyFlag = false;
        int profit = 0;

        for(int i=0;i<len;i++){
            if(i == len-1 ){
                if(buyFlag){
                    profit = profit + prices[i] - prices[buy.get(buy.size()-1)];
                }
                break;
            }
            else if(prices[i]<=prices[i+1]){
                if(buyFlag == false){
                
                    buyFlag = true; 
                    buy.add(i);
                }
            }else if(prices[i]>prices[i+1]){
                if(buyFlag){
                    buyFlag = false;
                    sell.add(i);
                    profit = profit + prices[i] - prices[buy.get(buy.size()-1)];

                }
            }
        }
        return profit;
    }
}
