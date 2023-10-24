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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int palindromicPartition(String str)
    {
       int n= str.length();
       int arr[] = new int[n+1];
       arr[0] = 0;
        
        for(int i=0; i<n; i++){
            int min = (int)(1e9);
            for(int j=i; j>=0; j--){
                if(inPalindrome(j, i, str)){
                    int res = 1+arr[j];
                    min = Math.min(res, min);
                }
            }
            arr[i+1] = min;
        }
        return arr[n]-1;
        
    }
    
    static boolean inPalindrome(int i, int j, String str){
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
