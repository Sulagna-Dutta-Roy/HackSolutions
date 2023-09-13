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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution {
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int mod=(int)1e9+7;
        int zero=1;
        int [][] dp=new int[n][sum+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
            if(arr[0]==0)zero=2;
            
        }
        if(arr[0]<=sum)
            dp[0][arr[0]]=1;
       
        
        for(int j=1;j<n;j++)
        {
            for(int t=0;t<=sum;t++)
            {
                int np=dp[j-1][t];
                int p=0;
                if(arr[j]<=t)
                    p=dp[j-1][t-arr[j]];
               dp[j][t]=(p+np)%mod;
                
            }
        }
        return dp[n-1][sum]*zero%mod;
	} 
}
