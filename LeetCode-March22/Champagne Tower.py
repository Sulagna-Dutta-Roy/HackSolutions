class Solution(object):
    def champagneTower(self, poured, query_row, query_glass):
        """
        :type poured: int
        :type query_row: int
        :type query_glass: int
        :rtype: float
        """
        A = [[0] * k for k in xrange(1, 102)]
        A[0][0]= poured
        for y in xrange(query_row + 1):
            for c in xrange(y+1):
                q = (A[y][c]-1.0)/2.0
                if q>0:
                    A[y+1][c] += q
                    A[y+1][c+1] += q
        return min(1, A[query_row][query_glass])