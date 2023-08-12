package geekForGeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Link : https://practice.geeksforgeeks.org/problems/subset-sums2234/1
public class subset_sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean [][] dp = new boolean [n+1][tar+1];
        
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i=0;i<n+1;i++){
            for(int j=1;j<tar+1;j++){
                if(i == 0 && j>0){
                    dp[i][j] = false;
                }else{
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                    }
                    else if((j-arr[i-1])>=0){
                        dp[i][j] = dp[i-1][j-arr[i-1]];
                    }
                }
            }
        }

        
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<tar+1;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n][tar]);
        for(int i=0;i<tar+1;i++){
            if(dp[n][i]){
                System.out.print(i+" ");
            }
        }

    }
}
