import java.io.*;
import java.util.*;


public class coin_change_permutation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(coins);
        
        int amt = Integer.parseInt(br.readLine());
        
        int [] dp = new int[amt+1];
        for (int i = 0; i < amt+1; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i < amt+1; i++) {
            dp[i] = solution(dp,coins,i);
            // System.out.println(i+" = "+dp[i]);
        }

        System.out.println(dp[amt]);


        
        
    }
    public static int solution(int [] dp,int [] coins,int amt){
        int res = 0;
        if(amt<0){
            return 0;
        }else if(amt == 0){
            return 1;
        }

        for(int i=0;i<coins.length;i++){
            if(amt-coins[i]>=0){
                if(dp[amt-coins[i]]>0){
                    res = res + dp[amt-coins[i]];
                }else{
                    res = res + solution(dp, coins, amt-coins[i]);
                }
            }
        }

        return res;
    }
    
    
}
