//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    private static boolean isHappy(int N) {
        if(N<10) {
          if(N==1 || N==7) 
            return true;
          else 
            return false;
    }
    long sum = 0;
    while(N>0) {
        int res = N%10;
        sum += res*res;
        N /= 10;
    }
    return isHappy((int)sum);
    }
    public static int nextHappy(int N){
       while(true){
        N++;
        if(isHappy(N)) 
        break;
    }
    return N;
} }
