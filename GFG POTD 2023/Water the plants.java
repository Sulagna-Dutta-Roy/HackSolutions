//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        int[][] range = new int[n][2];
        for(int i=0; i<n; i++){
            if(gallery[i] == -1){
                continue;
            }
            range[i][0] = i - gallery[i];
            if(range[i][0] < 0){
                range[i][0] = 0;
            }
            range[i][1] = i + gallery[i];
            if(range[i][1] >= n){
                range[i][1] = n;
            }
            //range[i][0] = Math.max(0, i-gallery[i]);
            //range[i][1] = Math.min(n-1, i+gallery[i]);
        }
        Arrays.sort(range, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        int start = 0, i = 0, res = 0;
        int currMax = -1;
        
        while(start < n){
            while(i < n){
                if(range[i][0]>start){
                    break;
                }
                currMax = Math.max(currMax, range[i][1]);
                i++;
            }
            if(currMax < start)
                return -1;
                
            res++;
            start = currMax+1;
        }
        return res;
    }
}
