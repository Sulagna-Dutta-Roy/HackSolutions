class Solution:
    def maximumScore(self, nums: List[int], multipliers: List[int]) -> int:
        dp = [0] * (len(multipliers) + 1)
        for m in range(len(multipliers) - 1, -1, -1):
            pd = [0] * (m + 1)
            for l in range(m, -1, -1):
                pd[l] = max(dp[l + 1] + multipliers[m] * nums[l], 
                            dp[l] + multipliers[m] * nums[~(m - l)])
            dp = pd
        return dp[0]
