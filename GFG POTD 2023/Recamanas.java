//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
       Set<Integer> s=new HashSet<>();
        ArrayList<Integer> l=new ArrayList<>();
        l.add(0);
        s.add(0);
        for(int i=1;i<n;i++){
            int a=l.get(i-1)-i;
            if(a>0 && !s.contains(a)){
                l.add(a);
                s.add(a);
            }
            else{
                a=l.get(i-1)+i;
                l.add(a);
                s.add(a);
            }
        }
        return l;
    }
}
