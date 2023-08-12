import java.util.Scanner;

public class tiling_with_2x1_tiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        } 


        System.out.println(dp[n]);
    }
    
}
