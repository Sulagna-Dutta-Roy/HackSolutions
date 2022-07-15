class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        rows = len(grid)
        cols = len(grid[0])
        visited = [[False for _ in range(cols)]for _ in range(rows)]
        
        def check(r, c):
            if r<0 or c<0 or r>=rows or c>=cols or visited[r][c]==True or grid[r][c]==0:
                return 0
            visited[r][c] = True           
            area = 1
            area += check(r-1, c)
            area += check(r+1, c)
            area += check(r, c-1)
            area += check(r, c+1)
            return area
            
        for i in range(rows):
            for j in range(cols):
                if grid[i][j]==1 and visited[i][j]==False:
                    currArea = check(i, j)
                    maxArea = max(maxArea, currArea)     
        return maxArea
