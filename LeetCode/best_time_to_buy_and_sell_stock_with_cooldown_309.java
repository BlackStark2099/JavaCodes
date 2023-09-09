package LeetCode;

import java.util.ArrayList;

public class best_time_to_buy_and_sell_stock_with_cooldown_309 {
    public static void main(String[] args) {
        int [] arr = new int[]{6,1,3,2,4,7};
        maxProfit(arr);
    }

    public static int maxProfit(int[] prices) {
        int len  = prices.length;
        ArrayList<Integer>  buy = new ArrayList<Integer>();
        ArrayList<Integer>  sell = new ArrayList<Integer>();
        ArrayList<Integer> profitArr = new ArrayList<>();
        Boolean buyFlag = false;
        int profit = 0;

        for(int i=0;i<len;i++){
            if(i == len-1 ){
                if(buyFlag){
                    sell.add(i);
                    // profit = profit + prices[i] - prices[buy.get(buy.size()-1)];
                }
                break;
            }
            else if(prices[i]<=prices[i+1]){
                if(buyFlag == false){
                    // System.out.println("buying at "+prices[i]);
                    buyFlag = true; 
                    buy.add(i);
                }
            }else if(prices[i]>prices[i+1]){
                if(buyFlag){
                    buyFlag = false;
                    sell.add(i);
                    // profit = profit + prices[i] - prices[buy.get(buy.size()-1)];
                    // System.out.println(profit);
                }
            }
        }
        System.out.println(buy);
        System.out.println(sell);
                for(int i=0;i<buy.size();i++){
            profitArr.add(prices[sell.get(i)] - prices[buy.get(i)]); 
        }
        System.out.println(profitArr);
        for(int i=1;i<buy.size();i++){
            if(buy.get(i) == (sell.get(i-1)+1)){
                int leftProfit = prices[sell.get(i-1)] - prices[buy.get(i-1)];
                int rightProfit = prices[sell.get(i)] - prices[buy.get(i)];
                // System.out.println(prices[sell.get(i)] - prices[buy.get(i-1)]+"------------------------");

                if(leftProfit>rightProfit){
                    buy.set(i, buy.get(i)+1);
                }
                else if (leftProfit<rightProfit){
                    // buy.set(i, buy.get(i)+1);
                    sell.set(i-1, sell.get(i-1)-1);
                }
                else{
                    int profitleft = prices[sell.get(i-1)-1] - prices[buy.get(i-1)];
                    int profitRight = prices[sell.get(i)] - prices[buy.get(i)+1];
                    System.out.println("profitleft ="+profitleft);
                    System.out.println("profitRight ="+profitRight);
                    
                    if(leftProfit-profitleft < rightProfit-profitRight){
                        sell.set(i-1, sell.get(i-1)-1);
                    }else{
                         buy.set(i, buy.get(i)+1);
                    }
                    
                }
                
                if(prices[sell.get(i)] - prices[buy.get(i-1)] >= leftProfit+rightProfit){
                    buy.remove(i-1);
                    sell.remove(i);
                }
            }
        }

        System.out.println(buy);
        System.out.println(sell);
        profitArr = new ArrayList<>();
        for(int i=0;i<buy.size();i++){
            profitArr.add(prices[sell.get(i)] - prices[buy.get(i)]); 
        }
        System.out.println(profitArr);
        for(int i=0;i<buy.size();i++){
            profit = profit + prices[sell.get(i)] - prices[buy.get(i)];
        }
        
        System.out.println(profit);
        
        return profit;
    }
}
