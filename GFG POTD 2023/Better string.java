//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        int dp[] = new int[str1.length()+1];
        dp[0] = 1;
        HashMap<Character,Integer> a = new HashMap<>();
        for(int i=1;i<=str1.length();i++)
        {
            if(a.containsKey(str1.charAt(i-1)))
            {dp[i] = (dp[i-1]*2)-dp[a.get(str1.charAt(i-1))-1];
            a.put(str1.charAt(i-1),i);
            }
            else{
            a.put(str1.charAt(i-1),i);
            dp[i] = dp[i-1]*2;
            }
        }
        int dp1[] = new int[str2.length()+1];
        dp1[0] = 1;
        a.clear();
        for(int i=1;i<=str2.length();i++)
        {
            if(a.containsKey(str2.charAt(i-1)))
            {dp1[i] = (dp1[i-1]*2)-dp1[a.get(str2.charAt(i-1))-1];
            a.put(str2.charAt(i-1),i);
            }
            else{
            a.put(str2.charAt(i-1),i);
            dp1[i] = dp1[i-1]*2;
            }
        }
        return dp1[str2.length()]>dp[str1.length()]?str2:str1;
    }
}
