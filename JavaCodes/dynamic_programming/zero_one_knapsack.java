import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class zero_one_knapsack {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int [][] dp = new int [values.length+1][cap+1];

        for(int i=0;i<values.length+1;i++){
            for(int j=0;j<cap+1;j++){
                if(i==0 || j == 0) {
                    continue;
                }
                if(j<wts[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wts[i-1]]+values[i-1]);
                }                
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
