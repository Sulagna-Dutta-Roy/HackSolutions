//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
Integer [][] dp = new Integer[S.length()][S.length()];
        return S.length() - lps(S,0,S.length() - 1, dp);
    }
    public static int lps(String s , int start, int end, Integer [][] dp)
    {
        if(start > end)
        return 0;
        if(start == end)
        return 1;
        if(dp[start][end] == null)
        {
        if(s.charAt(start) == s.charAt(end))
        dp[start][end] = 2 + lps(s,start + 1, end - 1,dp);
        else
        dp[start][end] = Math.max(lps(s,start + 1, end,dp) , lps(s,start, end - 1,dp));
        }
        return dp[start][end];
    }
}
