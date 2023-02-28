import java.io.*;

public class paint_house_many_colours {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        String[] numItems = num.split(" ");
        int n = Integer.parseInt(numItems[0]);
        int m = Integer.parseInt(numItems[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(items[j]);
            }
        }
        int [][] dp = new int [n][m]; 
        for(int i=0;i<m;i++){
            dp[0][i] = arr[0][i];
        }
    
        for(int p=1;p<n;p++){
            for(int q=0;q<m;q++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<m;k++){
                    if(q==k){
                        continue;
                    }
                    min = Math.min(min, dp[p-1][k]);
                }
                dp[p][q] = min+arr[p][q];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            min = Math.min(min,dp[n-1][i]);
        }
        System.out.println(min);
    }
}
