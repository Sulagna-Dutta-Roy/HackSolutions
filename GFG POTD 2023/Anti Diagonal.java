

//User function Template for Java

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int n = matrix.length;
         int [] ans = new int[n*n];
         int index = 0;
         //upper matrix traversal 
         for(int i=0;i<n;i++){
             int row = 0, col = i;
             while(row<n&&col>=0){
                 ans[index++] = matrix[row++][col--];
             }
         }
         //lower matrix traversal
         for(int i=1;i<n;i++){
             int row=i, col = n-1;
             while(row<n&&col>=0){
                 ans[index++] = matrix[row++][col--];
             }
         }
         return ans;

    }
}
