class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def checkValid(row, col, col_in_row):
            for r in range(row):
                if row - r == abs(col - col_in_row[r]):
                    return False
                
            return True
        
        def placeQueen(row, cols, col_in_row):
            if row == n:
                result.append(["".join('Q' if c == col_in_row[r] else '.'
                                       for c in range(n)) for r in range(n)])
                return
                
            for col in range(n):
                if cols[col] == 0 and checkValid(row, col, col_in_row):
                    cols[col] = 1
                    col_in_row[row] = col
                    placeQueen(row + 1, cols, col_in_row)
                    cols[col] = 0
                    
        result = []
        placeQueen(0, [0]*n, [0]*n)
        
        return result