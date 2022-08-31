class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        
        atlantic_vis = [[False for _ in range(n)] for _ in range(m)]
        pacific_vis = [[False for _ in range(n)] for _ in range(m)]
        
        atlantic = deque()
        pacific = deque()
        
        for r in range(m):
            for c in range(n):
                if r == 0 or c == 0:
                    pacific_vis[r][c] = True
                    pacific.append((r, c))
                if r == m-1 or c == n-1:
                    atlantic_vis[r][c] = True
                    atlantic.append((r, c))
                    
        def bfs(queue, vis_mat):
            reach = set()
            
            while queue:
                r, c = queue.popleft()
                reach.add((r, c))

                for nr, nc in [(r, c-1), (r, c+1), (r+1, c), (r-1, c)]:
                    if not (0 <= nr < m and 0 <= nc < n): continue
                    if vis_mat[nr][nc]: continue

                    if heights[nr][nc] >= heights[r][c]:
                        vis_mat[nr][nc] = True
                        queue.append((nr, nc))
            return reach
            
        
        # atlantic BFS
        atlantic_reach = bfs(atlantic, atlantic_vis)
        # pacific BFS
        pacific_reach = bfs(pacific, pacific_vis)
        
        return [[r, c] for r in range(m) for c in range(n) if (r,c) in pacific_reach and (r,c) in atlantic_reach]
            
