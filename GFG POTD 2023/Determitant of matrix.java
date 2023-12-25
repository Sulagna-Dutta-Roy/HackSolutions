//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        if(n==1) return matrix[0][0];
        if(n==2) return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
        int total=0;
        int mat[][]=new int[n-1][n-1];
        for(int i=0;i<n;i++){
            for(int row=1;row<n;row++){
                int col_i=0;
                for(int col=0;col<n;col++){
                    if(col==i) continue;
                    mat[row-1][col_i++]=matrix[row][col];
                }
            }
            total += ((i%2==0)?1:-1)*matrix[0][i]*determinantOfMatrix(mat,n-1);
        }
        return total;
    }
}

