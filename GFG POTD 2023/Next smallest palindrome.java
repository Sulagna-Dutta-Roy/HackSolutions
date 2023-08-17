//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Vector<Integer> generateNextPalindrome(int num[], int n) {
       int m=n/2;
        int l=m-1;
        int r=(n%2==1) ? m+1:m;
        while(l>=0 && num[l]==num[r]) {
            l--;
            r++;
        }
        Vector<Integer> v=new Vector<Integer>();
        int carry=0;
        if(l<0 || num[l]<num[r]) {
            carry=1;
        }
        l=m;
        if(n%2==0) {
            l=m-1;
        }
        r=m;
        while(l>=0) {
            num[l]+=+carry;
            carry=num[l]/10;
            num[l]%=10;
            num[r]=num[l];
            l--;
            r++;
        }
        if(carry==1) {
            num[n-1]=1;
            v.addElement(1);
        }
        for(int ele:num) {
            v.add(ele);
        }
        return v;
    }
}
