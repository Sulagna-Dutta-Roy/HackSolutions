//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
long arr[] = new long[n];
        
        for(int i =0;i<n;i++){
            arr[i] = price[i]*100000+(i+1);
        }
        
        Arrays.sort(arr);
        int count = 0;
        for(int i =0;i<n;i++){
            int pr = (int)arr[i]/100000;
            int no = (int)arr[i]%100000;
            
            if(pr*no > k){
                count += k/pr;
                k = k - pr*(k/pr);
            }else{
                count = count+no;
                k = k - pr*no;
            }
            
        }
        
        return count;
    }
}
        
