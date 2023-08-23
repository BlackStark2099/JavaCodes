class Solution {
    int mod = 1000000007;
    public int countTexts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] % mod;
            if(i > 1 && s.charAt(i-1) == s.charAt(i-2)) {
                dp[i] = (dp[i] + dp[i-2]) % mod;
                if(i > 2 && s.charAt(i-1) == s.charAt(i-3)) {
                    dp[i] = (dp[i] + dp[i-3]) % mod;
                    if(i > 3 && (s.charAt(i-1) == '7' || s.charAt(i-1) == '9') && s.charAt(i-1) == s.charAt(i-4)) {
                        dp[i] = (dp[i] + dp[i-4]) % mod;
                    }
                }
            }
        }
        return dp[n];
    }
}