class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        n, m = len(s1), len(s2)
        if n + m != len(s3): return False
        dp = [True] * (m+1)
        for i in range(1, m+1):
            dp[i] = dp[i-1] and s2[i-1] == s3[i-1]
        for i in range(n):
            dp[0] = dp[0] and s1[i] == s3[i] 
            for j in range(m):
                dp[j+1] = (dp[j+1] and s1[i] == s3[i+j+1]) or (dp[j] and s2[j] == s3[i+j+1])
        return dp[-1]
