//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int smithNum(int n) {
        if(isPrime(n)) return 0;
        return digitSum(n)==factorSum(n)? 1 : 0;
    }
    private static int factorSum(int n){
        int i=2, sum=0;  
        while(n>1) {  
            if(n%i==0){  
                sum+=digitSum(i);  
                n=n/i;  
            }  
            else{  
                do{  
                    i++;  
                }  
                while(!isPrime(i));  
            }  
        }  
        return sum;
    }
    private static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int div = 2; div * div <= n; div++) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }
    
    private static int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
};
