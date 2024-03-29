import java.io.*;
public class unbounded_knapsack {
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

        int [] dp = new int[cap+1];
        
        for(int i=0;i<n;i++){
            for(int j=wts[i];j<cap+1;j++){
                dp[j] = Math.max(dp[j],values[i]+dp[j-wts[i]]);
            }
        }
        

        System.out.println(dp[cap]);
        
    }
}
