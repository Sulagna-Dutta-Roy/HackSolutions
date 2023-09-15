//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += arr[i];
        }
        
        if(sum %2 == 1) return 0;
        
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        return (subset(arr, sum, N-1, dp) == true) ? 1:0;
    }
    
    static boolean subset(int[] arr, int sum , int N, boolean[] dp) {
        if(sum == 0) return true;
        if(N <= 0) return false;
        if(sum < 0) return false;
        
        if(dp[sum] == true) return false;
        
        return dp[sum] = subset(arr, sum-arr[N-1], N-1, dp) || subset(arr, sum, N-1, dp);
    }
}
