import java.util.Arrays;

public class coin_change_1_leetcode {
    public static void main(String[] args) {
        int [] arr = new int[]{186,419,83,408};
        
        System.out.println(coinChange(arr, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int m = coins.length;
        int n = amount;  
        Arrays.sort(coins);
        int [][] res = new int [coins.length+1][amount+1];
        for(int p=0;p<m+1;p++){
            for(int q=0;q<n+1;q++){
                res[p][q] = -1;
            }
        }


        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(j == 0){
                    res[i][j] = 0; 
                }else if(i == 0){
                    res[i][j] = -1;
                }
                else{
                    if(j<coins[i-1]){
  
                            res[i][j] = res[i-1][j];
                    }else{
                        if(j%coins[i-1] == 0){
                            res[i][j] = j/coins[i-1];
                        }
                        else{
                            res[i][j] = 1+res[i][j-coins[i-1]];
                        }
                    } 
                }
                if(i>0 && res[i-1][j]>0 && res[i][j]>0){
                    res[i][j] = Math.min(res[i-1][j],res[i][j]);
                }else if (i>0 && res[i-1][j]>0 && res[i][j]<=0){
                    res[i][j] = res[i-1][j];
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i =0;i<res.length;i++){
            System.out.println(res[i][amount-1]);
            if(res[i][amount] > 0){
                min = Math.min(min,res[i][amount]);
            }
        }

        if(min == Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }  
                
    }
}
