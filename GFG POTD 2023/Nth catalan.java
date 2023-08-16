//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        int mod = (int)1e9+7;
        if(n<=1) {
            return 1;
        }
        int[] num = new int[n+1];
        num[0] = num[1]=1;
        for(int i=2;i<=n;i++) {
            for(int j=0;j<i;j++) {
                num[i] = (num[i]+(int)((long)num[j]*num[i-j-1]%mod))%mod;
            }
        }
    return num[n];
    }
}
        
