import java.io.*;
import java.util.*;

public class coin_change_combination {
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


        
        
        
        // Solution 1
        // int [][] dp = new int[n+1][amt+1];
        // for(int i=1;i<n+1;i++){
        //     for(int j=1;j<amt+1;j++){
        //         int tempRes = 0 ;
        //         if(j<coins[i-1]){

        //         }
        //         else if(j-coins[i-1] == 0){
        //             tempRes++;
        //         }else if(j-coins[i-1] > 0){
        //             if(dp[i][j-coins[i-1]] == 0){
        //                 tempRes = 0;
        //             }else{
        //                tempRes++;
        //             }
        //         }
        //         dp[i][j] = dp[i-1][j] + tempRes;
        //     }
        // }

        // for(int p=0;p<n+1;p++){
        //     for(int q=0;q<amt+1;q++){
        //         System.out.print(dp[p][q]+"  ");
        //     }
        //     System.out.println();
        // }
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
