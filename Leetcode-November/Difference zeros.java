class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowdiff = new int[grid.length];
        int[] coldiff = new int[grid[0].length];

        //calculate the diff arrays
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    rowdiff[i]++;
                    coldiff[j]++;
                } else {
                    rowdiff[i]--;
                    coldiff[j]--;
                }
            }
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j] = rowdiff[i] + coldiff[j];
            }
        }

        return grid; 
    }
}
