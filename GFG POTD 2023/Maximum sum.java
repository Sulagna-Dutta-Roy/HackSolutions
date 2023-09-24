//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
       Arrays.sort(A);
       Arrays.sort(B);
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       int a=N-1,b=N-1;
       
       
       for(int j=N-1;j>N-K-1;j--)
       {
           for(int k=N-1;k>N-K-1;k--)
           {
               int n=A[j]+B[k];
               if(pq.size()<K)
               pq.add(n);
               else
               {
                   if(pq.peek()<n)
                   {
                       pq.poll();
                       pq.add(n);
                   }
                   else
                   break;
               }
           }
       }
       List<Integer> ans=new ArrayList<>();
       while(!pq.isEmpty())
       {

           if(ans.isEmpty())
           ans.add(pq.poll());
           else
           ans.add(0,pq.poll());
           
           
       }
       
       return ans;
    }
}
