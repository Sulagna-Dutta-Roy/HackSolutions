class Solution {
    public int countNegatives(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       int i = m-1;
       int j =0;
       int res=0;
       while(i>=0 && j<n){
          if(grid[i][j]<0) {
              i--;
              res += n-j;
          } else{
              j++;
          }
       }
    return res;
    }
}
