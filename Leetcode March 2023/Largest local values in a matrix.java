class Solution {
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int max;
        int[][] m = new int[len-2][len-2];
        for(int i = 0; i < len - 2; i++) {
            for(int j = 0; j < len - 2; j++){
                max = 0;
                for(int x = i; x < i + 3; x++){
                    for(int y = j; y < j + 3; y++){
                        if(grid[x][y] > max){
                            max = grid[x][y];
                        }
                    }
                }
                m[i][j] = max;
            }
        }
        return m;
    }
}
