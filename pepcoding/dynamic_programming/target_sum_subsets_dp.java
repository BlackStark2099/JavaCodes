import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class target_sum_subsets_dp {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i = 0; i < n; i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }

        // int tar = Integer.parseInt(br.readLine());

        // boolean [][] dp = new boolean [n+1][tar+1];
        
        // for(int i=0;i<n+1;i++){
        //     dp[i][0] = true;
        // }

        // for(int i=0;i<n+1;i++){
        //     for(int j=1;j<tar+1;j++){
        //         if(i == 0 && j>0){
        //             dp[i][j] = false;
        //         }else{
        //             if(dp[i-1][j]){
        //                 dp[i][j] = true;
        //             }
        //             else if((j-arr[i-1])>=0){
        //                 dp[i][j] = dp[i-1][j-arr[i-1]];
        //             }
        //         }
        //     }
        // }

        
        // // for(int i=0;i<n+1;i++){
        // //     for(int j=0;j<tar+1;j++){
        // //         System.out.print(dp[i][j]+" ");
        // //     }
        // //     System.out.println();
        // // }
        // System.out.println(dp[n][tar]);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        int [][] dp = new int [n+1][tar+1];
        
        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }

        // int [] temp = new int [tar+1];
        // temp[0] = 1;

        for(int i=0;i<n+1;i++){
            for(int j=1;j<tar+1;j++){
                if(i == 0 && j>0){
                    dp[i][j] = 0;
                }else{
                    if((j-arr[i-1])>=0){
                        dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<tar+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        // System.out.println(dp[n][tar]);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<tar+1;i++){
            for(int j=0;j<dp[n][i];j++){
                res.add(i);
            }
        }
        System.out.println(res);
        
    }
}
