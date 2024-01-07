//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int sum = 0;
        for (int i:arr) {
            sum += i;
        }
        int start = 1;
        int end = sum;
    
        while(start<=end) {
            int mid = (start+end)/2;
           
            if (isPosible(mid,K,arr)) {
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        
        return end+1;
    }
    
    static boolean isPosible(int mid,int k, int[] arr) {
    
        int sum = 0;
        int count = 0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            if (arr[i]>mid) return false;
            if (sum>mid) {
                count++;
                sum = arr[i];
            }
        }
        if (sum<=mid) {
            count++;
        }
       
        if (k>=count) return true;
        return false;
    }
};
