package LeetCode;

public class count_sorted_vowel_strings_1641 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
    }
    public static int countVowelStrings(int n) {
        int [][] dp = new int[5][n+1];
        for(int i = 0;i<5;i++){
            dp[i][0] = 1;
        } 
        for(int i = 1;i<n;i++){
            int lastSum = 0;
            for( int j = 4 ; j >= 0 ; j-- ){
                lastSum =  lastSum + dp[j][i-1];
                dp[j][i] = lastSum;
                System.out.println(lastSum);
            }
        }


        for(int i = 0;i<5;i++){
            for( int j = 0 ; j < n ; j++ ){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int res = 0;
        for(int i = 0;i<5;i++){
            res = res + dp[i][n-1];
        } 
        return res;
    }
}
