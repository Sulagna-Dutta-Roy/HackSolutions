//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        int a = 100000;
        int dp[] = new int[100001];
        Arrays.fill(dp,-1);
        Queue<Integer> q=new LinkedList<>();
        q.add(start%a);
        dp[start]=0;
        while(!q.isEmpty())
        {
            int t=q.poll();
            if(t==end)
            return dp[end];
            for(int i=0;i<n;i++)
            {
                int p=((t%a)*(arr[i]%a))%a;
                if(dp[p]==-1)
                {
                    dp[p]=dp[t]+1;
                    q.add(p);
                }
            }
        }
        return -1;
    }
}
