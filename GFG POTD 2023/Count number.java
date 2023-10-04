//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        return solve(S,K)-solve(S,K-1);
    }
    long solve(String S, int K) {
        int i=0,j=0,size=0,n=S.length();
        long ans=0;
        int[] map = new int[26];
        while(j<n) {
            char cha = S.charAt(j);
            if(map[cha-'a']==0) size++;
            map[cha-'a']++;
            while(size>K) {
                char chr = S.charAt(i);
                map[chr-'a']--;
                if(map[chr-'a']==0) size--;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}
