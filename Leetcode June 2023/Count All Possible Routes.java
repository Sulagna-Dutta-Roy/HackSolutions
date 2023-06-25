class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
      final int MOD = 1000000007;
        int n = locations.length;
        
        int[][] dp = new int[n][fuel + 1];
        for (int f = 0; f <= fuel; f++) {
            dp[finish][f] = 1;
        }
        
        for (int f = 0; f <= fuel; f++) {
            for (int city = 0; city < n; city++) {
                for (int nextCity = 0; nextCity < n; nextCity++) {
                    if (nextCity != city && f >= Math.abs(locations[nextCity] - locations[city])) {
                        dp[city][f] = (dp[city][f] + dp[nextCity][f - Math.abs(locations[nextCity] - locations[city])]) % MOD;
                    }
                }
            }
        }
        
        return dp[start][fuel];
   
    }
}
