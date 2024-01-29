//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalCount(String str)
    {
        int dp[][] = new int[101][1001];
       for(int row[] : dp)
       {
           Arrays.fill(row,-1);
       }
        return sub(str,0,0,dp);
    }
    public static int sub(String str,int index,int sum,int dp[][])
    {
        if(index == str.length()) return 1;
        int cur = 0;
        int ans = 0;
        if(dp[index][sum] != -1) return dp[index][sum];
        for(int i = index; i < str.length();i++)
        {
            cur += (str.charAt(i) - '0');
            
            if(cur >= sum)
            ans += sub(str,i + 1,cur,dp);
     
        }
    
        return dp[index][sum] = ans;
    }
}
