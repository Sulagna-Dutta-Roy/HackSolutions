//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        int ans = 0;
        int res = 0;
        int flip = 0;
        for(int i=0;i<n;i++) {
            if(a[i]==0) {
                ans++;
            }
            else {
                res++;
                ans--;
            }
        flip = Math.max(flip,ans);
        if(ans<0) {
            ans=0;
          }
        }
    return res+flip;
    }
}
