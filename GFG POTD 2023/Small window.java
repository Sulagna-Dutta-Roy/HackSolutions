//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int zero = -1, one = -1, two = -1;
        int min = Integer.MAX_VALUE, i = 0;
        while (i < S.length()) {
            if(S.charAt(i) == '0'){
                zero = i;
            }else if(S.charAt(i) == '1'){
                one = i;
            }else two = i;
            
            if((zero !=-1 && one!=-1 && two!=-1)){
                int temp = Math.max(zero, Math.max(two, one)) 
                - Math.min(zero, Math.min(two, one)) + 1;

                if(min>temp){
                    min = temp;
                }
            }
            i++;
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
    }
} 
}
