//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int j = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(j<=i && hm.size() > k){
                char ch = s.charAt(j);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0)
                hm.remove(ch);
                j++;
            }
            max = Math.max(max,(i-j)+1);
        }
        if(hm.size() < k)
        return -1;
        return max;
    }
}
