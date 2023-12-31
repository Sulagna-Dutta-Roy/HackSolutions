//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isPossible(int N, int[] coins) {
        return helper(0,coins,N,0);
    }
    public static boolean helper(int idx,int coins[],int n,int sum){
        if(sum!=0 && (sum%2024==0 ||sum%20==0||sum%24==0)){
            return true;
        }
        if(idx==coins.length){
            return false;
        }
        
        boolean temp1=helper(idx+1,coins,n,sum+coins[idx]);
        if(temp1==true)return true;
        
        boolean temp2=helper(idx+1,coins,n,sum);
        if(temp2==true)return true;
        
        return false;
    }
}
        
