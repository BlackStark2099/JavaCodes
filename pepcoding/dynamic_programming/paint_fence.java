import java.util.Scanner;

public class paint_fence {
    public static void main(String[] args) {
        Scanner inpyScanner = new Scanner(System.in);
        int fence = inpyScanner.nextInt();
        int colors = inpyScanner.nextInt();
        int [][] dp = new int [3][fence];
        dp[0][0] = 0;
        dp[1][0] = colors;
        dp[2][0] = dp[0][0] + dp[1][0];
        for(int i=1;i<fence;i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[2][i-1]*(colors-1);
            dp[2][i] = dp[0][i] + dp[1][i];
        }

        
        System.out.println(dp[2][fence-1]);
    }
}
