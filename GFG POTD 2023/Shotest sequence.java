//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

public static int shortestCommonSupersequence(String X,String Y,int m,int n)
{
        //Your code here
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return m + n - LCS(X, Y, m - 1, n - 1, dp);
}
    
public static int LCS(String s1, String s2, int i, int j, int[][] dp)
{
        if(i < 0 || j < 0) {
            return 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
        }
        else {
            dp[i][j] = Math.max(LCS(s1, s2, i, j - 1, dp), LCS(s1, s2, i - 1, j, dp));
        }
        
        return dp[i][j];
}

