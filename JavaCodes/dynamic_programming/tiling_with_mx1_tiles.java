import java.util.Scanner;

public class tiling_with_mx1_tiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 0;
        for(int i=0;i<n+1;i++){
            if(i<m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }
            else if(i>m){
                dp[i] = dp[i-m]+dp[i-1]; 
            }
            System.out.print(dp[i]+ " ");
        }
    }    
}
