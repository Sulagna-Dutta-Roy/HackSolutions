class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = (int)1e9 + 7;
        int N = group.length;
        int[][][] dp = new int[N+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int g = group[i-1];
            int p = profit[i-1];
            for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= minProfit; k++) {
                dp[i][j][k] = (dp[i-1][j][k] + (j >= g ? dp[i-1][j-g][Math.max(0, k-p)] : 0)) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[N][j][minProfit]) % MOD;
        }
        return ans;
    }
}
