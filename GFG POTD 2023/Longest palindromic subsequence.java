//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
