class Solution:
    def totalNQueens(self, n: int) -> int:
        visited_cols=set()
        visited_diagonals=set()
        visited_antidiagonals=set()
        
        res=set()
        def backtrack(r):
            if r==n:  # valid solution state   
                return 1
                        
            cnt=0
            for c in range(n):
                if not(c in visited_cols or (r-c) in visited_diagonals or (r+c) in visited_antidiagonals):
                    visited_cols.add(c)
                    visited_diagonals.add(r-c)
                    visited_antidiagonals.add(r+c)                    
                    cnt+=backtrack(r+1) # count the overall tally from this current state
                    
                    visited_cols.remove(c)
                    visited_diagonals.remove(r-c)
                    visited_antidiagonals.remove(r+c)                    
            
            return cnt
        
        return backtrack(0)