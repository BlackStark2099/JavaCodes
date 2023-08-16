package LeetCode;

public class ones_and_zeroes_474 {
    public static void main(String[] args) {
        String [] arr = new String[]{"000","0111","0111","0111"};
        System.out.println(findMaxForm(arr, 3, 9));
    }

    public static class DP_class {
        int zeroLeft = 0;
        int subset = 0;
        int target = 0;
        boolean isPossible = false;

        @Override
    public String toString() {
        return "DP_class{" +
               "zeroLeft=" + zeroLeft +
               ", subset=" + subset +
               ", target=" + target +
               ", isPossible=" + isPossible +
               '}';
    }
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int [] zero = new int[strs.length];
        int [] one = new int [strs.length];
        for(int i = 0;i<strs.length;i++){
            for(int j = 0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '1'){
                    one[i]++;
                }else{
                    zero[i]++;
                }
            }
        }   
        DP_class [][] dp = new DP_class[strs.length+1][n+1];

        for(int i=0;i<=strs.length;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = new DP_class();
            }
        }

        
        for(int i=0;i<=strs.length;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = new DP_class();
            }
        }
        
        for(int i=0;i<=strs.length;i++){
            dp[i][0].target = 1;
            dp[i][0].isPossible = true;
            dp[i][0].zeroLeft = m;
            
        }
        for(int i=0;i<=n;i++){
            dp[0][i].zeroLeft = m;
        }

        for(int i=1;i<=strs.length;i++){
            for(int j=0;j<=n;j++){
                if(j < one[i-1]){
                    dp[i][j].subset = dp[i-1][j].subset;
                    dp[i][j].target = dp[i-1][j].target;
                    dp[i][j].zeroLeft = dp[i-1][j].zeroLeft;
                    dp[i][j].isPossible = dp[i-1][j].isPossible;
                }else if(dp[i-1][j-one[i-1]].isPossible){
                    dp[i][j].target = j;                   
                    int subsets = dp[i-1][j-one[i-1]].subset+1;
                    int zeroLeft = dp[i-1][j-one[i-1]].zeroLeft - zero[i-1];
                    if(zeroLeft < 0){
                        dp[i][j].isPossible = dp[i-1][j].isPossible; 
                        dp[i][j].subset = dp[i-1][j].subset;
                        dp[i][j].zeroLeft = dp[i-1][j].zeroLeft;
                    }else{
                        if(subsets > dp[i-1][j].subset){
                        dp[i][j].subset = subsets;
                        dp[i][j].zeroLeft = zeroLeft;
                        dp[i][j].isPossible = dp[i-1][j-one[i-1]].isPossible; 
                    }else if(subsets < dp[i-1][j].subset){
                        dp[i][j].subset = dp[i-1][j].subset;
                        dp[i][j].zeroLeft = dp[i-1][j].zeroLeft;
                        dp[i][j].isPossible = dp[i-1][j].isPossible; 
                    }else{
                        if(zeroLeft >dp[i-1][j].zeroLeft ){
                            dp[i][j].subset = subsets;
                            dp[i][j].zeroLeft = zeroLeft;
                            dp[i][j].isPossible = dp[i-1][j-one[i-1]].isPossible;
                        }else{
                            dp[i][j].subset = subsets;
                            dp[i][j].zeroLeft =  dp[i-1][j].zeroLeft;
                            dp[i][j].isPossible = dp[i-1][j].isPossible;
                        }   
                    }
                    }
                }else{
                    dp[i][j].subset = dp[i-1][j].subset;
                    dp[i][j].target = dp[i-1][j].target;
                    dp[i][j].zeroLeft = dp[i-1][j].zeroLeft;
                    dp[i][j].isPossible = dp[i-1][j].isPossible;
                }
            }
        }
        int subsets = 0;
        for(int i=0;i<=n;i++){
            if(dp[strs.length][i].subset >= subsets){
                subsets = dp[strs.length][i].subset;
            }
        }


                for(int i=0;i<=strs.length;i++){
            for(int j=0;j<=n;j++){
                System.out.println("i = "+i+" j = "+j+" "+dp[i][j]);
            }
        }

        // for(int i = 0;i<strs.length;i++){
        //     System.out.print(one[i]+" ");
        // }   
        // System.out.println();
        // for(int i = 0;i<strs.length;i++){
        //     System.out.print(zero[i]+" ");
        // }   
        return subsets;
    }
    
}
