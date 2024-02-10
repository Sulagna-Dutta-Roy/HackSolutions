//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long numberOfPath(int n, int k, int [][]arr) {
        long[][][] dp = new long[n][n][k+1];
       
       for(long[][] matrix : dp)
         for(long[] row : matrix)
            Arrays.fill(row, -1);
         
       return helper(n - 1, n - 1, k, arr, dp);
    }
    
    private long helper(int i, int j, int k, int[][] arr, long[][][] dp) {
        // Check if we reached the bottom-right corner and collected exactly k coins
        if (i == 0 && j == 0 && k == arr[i][j]) {
            return 1;
        }
        
        // If k becomes negative or we move out of the matrix boundaries, return 0
        if (i < 0 || j < 0 || k < 0) {
            return 0;
        }
        
        if(dp[i][j][k]!=-1)
          return dp[i][j][k];
        
        // Calculate the number of paths by moving up and left
        return dp[i][j][k] = helper(i - 1, j, k - arr[i][j], arr, dp) + helper(i, j - 1, k - arr[i][j], arr, dp);
    }
}
