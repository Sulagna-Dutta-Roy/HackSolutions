class Solution {
    public int minPathSum(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        
        int[][] ab = new int[a][b];
        ab[0][0] = grid[0][0];
        
        for (int i = 1; i < b; i++) {
            ab[0][i] = ab[0][i-1] + grid[0][i];
        }
        
        for (int i = 1; i < a; i++) {
            ab[i][0] = ab[i-1][0] + grid[i][0];
        }
        
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                ab[i][j] = Math.min(ab[i-1][j], ab[i][j-1]) + grid[i][j];
            }
        }
        
        return ab[a-1][b-1];
    }
}
