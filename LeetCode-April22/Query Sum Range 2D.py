class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        numRows, numCols = len(matrix), len(matrix[0])
        self.sumMatrix = [[0 for _ in range(numCols + 1)] for _ in range(numRows + 1)]
        for i in range(numRows):
            for j in range(numCols):
                self.sumMatrix[i + 1][j + 1] = matrix[i][j] +\
                                               self.sumMatrix[i][j + 1] +\
                                               self.sumMatrix[i + 1][j] -\
                                               self.sumMatrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return self.sumMatrix[row2 + 1][col2 + 1] -\
               self.sumMatrix[row1][col2 + 1] -\
               self.sumMatrix[row2 + 1][col1] +\
               self.sumMatrix[row1][col1]