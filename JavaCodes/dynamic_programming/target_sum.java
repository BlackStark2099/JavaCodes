import java.io.*;

public class target_sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean [][] res = new boolean[n+1][tar+1];
        res[0][0] = true;

        for(int i=1;i<n+1;i++){
            for(int j=0;j<tar+1;j++){
                if( j == 0){
                    res[i][j] = true;
                }
                else{
                    if(res[i-1][j]) {
                        res[i][j] = true;
                    }
                    else if(j<arr[i-1]){
                        res[i][j] = false;
                    }else{
                        if(res[i-1][j-arr[i-1]] || res[i-1][j]) res[i][j] = true;
                        else res[i][j] = false;
                    }
                }
            }
        }

        System.out.println(res[n][tar]);
    }
}
