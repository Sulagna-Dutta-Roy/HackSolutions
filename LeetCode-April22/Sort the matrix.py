class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        row, col = len(mat), len(mat[0])
	    total_num = row * col

	for i in range(1, row + col - 2):
		if i < row:
			start_row, start_col = row - i - 1, 0
		else:
			start_row, start_col = 0, i - row + 1

		diag = []
		while start_row < row and start_col < col:
			diag.append(mat[start_row][start_col])
			start_row += 1
			start_col += 1

		diag.sort()
		start_row -= 1
		start_col -= 1
		while start_row >= 0 and start_col >= 0:
			mat[start_row][start_col] = diag.pop()
			start_row -= 1
			start_col -= 1

	return(mat)
