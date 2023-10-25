//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int knap(int N,int W,int val[],int wt[],int dp[]){
        if(W==0) return 0;
        if(dp[W]!=-1) return dp[W];
        int maxAns=0;
        for(int i=0;i<N;i++){
            if(wt[i]<=W) maxAns=Math.max(maxAns,val[i]+knap(N,W-wt[i],val,wt,dp));
        }
        return dp[W]=maxAns;
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[]=new int[W+1];
        Arrays.fill(dp,-1);
        return knap(N,W,val,wt,dp);
    }
}
