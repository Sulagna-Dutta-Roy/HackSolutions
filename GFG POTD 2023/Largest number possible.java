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
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        if (9*N<S || (S == 0 && N != 1)) 
            return "-1";
        String ans = "";
        int i = 9;
        
        while(N>0){
            if(S>=i){
                ans = ans + Integer.toString(i);
                S -= i;
                N--;
            }
            else if(S<i)
                i--;
        }
        
        return ans;
    }
}
