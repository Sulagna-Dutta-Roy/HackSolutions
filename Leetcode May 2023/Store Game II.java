class Solution {
    private int stoneGameIIHelp(int ind, int m, int dp[][], int[] preSum){
        if( ind >= preSum.length ) return 0;
        if( dp[ind][m] != -1 ) return dp[ind][m];

        int maxi = 0, n = preSum.length;
        for(int x=1; x <= Math.min(2*m, n-ind); x++)
            maxi = Math.max(maxi, preSum[ind] - stoneGameIIHelp(ind+x, Math.max(m, x), dp, preSum));

        return dp[ind][m] = maxi;
    }


    // TOP DOWN
    public int stoneGameII1(int[] piles) {
        int n = piles.length;
        for(int i=n-2; i>=0; i--) piles[i] += piles[i+1];
        int dp[][] = new int[n][n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return  stoneGameIIHelp(0, 1, dp, piles);
    }


    // Bottom Up
    int stoneGameII(int[] preSum) {
        int n = preSum.length;
        for(int i=n-2; i>=0; i--) preSum[i] += preSum[i+1];
        int dp[][] = new int[n+1][n+1];
        
        for(int ind=n-1; ind>=0; ind--){
            for(int m = n; m>=1; m--){
                int maxi = 0;
                for(int x=1; x<=Math.min(2*m, n-ind); x++)
                    maxi = Math.max(maxi, preSum[ind] - dp[ind+x][Math.max(m, x)]);
        
                dp[ind][m] = maxi;
            }
        }
        return dp[0][1];
    }
}
