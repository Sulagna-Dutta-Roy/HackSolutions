class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        @lru_cache(None)
        def dp(i, j, moves_left):
			# Out of bounds
            if i < 0 or j < 0 or i >= m or j >= n:
                return 1
            
			# Nowhere to go
            if moves_left == 0:
                return 0
            
			# Try to move until out of bounds
            moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
            return sum(
                dp(i + v, j + h, moves_left - 1) for v, h in moves
            )
                    
        return dp(startRow, startColumn, maxMove) % (10 ** 9 + 7)
