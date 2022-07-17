class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        
        dp = [0] * (k+1)
        dp[0] = 1
        for i in range(2, n+1):
            for j in range(1, k+1): 
                dp[j] += dp[j - 1]
            for j in range(k, 0, -1): 
                dp[j] -= ((j-i) >= 0 and dp[j - i])
        return dp[k] % int(1e9 + 7)
