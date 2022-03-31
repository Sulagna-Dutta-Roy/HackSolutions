class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        dp = [[float("inf") for _ in range(len(nums))] for _ in range(m)]
        dp[0][0] = nums[0]
        for j in range(1, len(nums)):
            dp[0][j] = dp[0][j-1] + nums[j]
        
        for i in range(1,m):
            for j in range(i, len(nums)):
                dp[i][j] = min([max(dp[i-1][k],dp[0][j]-dp[0][k]) for k in range(i-1, j)])
        return dp[-1][-1]
        