class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        n,m=len(obstacleGrid),len(obstacleGrid[0])
        dp=[[0]*(m+1) for i in range(n+1)]
        dp[1][0]=1
        for i in range(1,n+1):
            for j in range(1,m+1):
                if(obstacleGrid[i-1][j-1]==0):
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]
        return dp[n][m]