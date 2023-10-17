//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int grid[][])
    {
        // code here
        ArrayList<ArrayList<Integer>>a = new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
                    for(int j=0;j<grid.length;j++)
                    {
                        
                                for(int k=0;k<grid.length;k++)
                                {
                                    if(k==j)
                                    grid[j][k]=1;
                                    if(grid[j][k]==0)
                                    {
                                        if(grid[j][i]==1 && grid[i][k]==1)
                                        grid[j][k]=1;
                                    }
                                }

                    }

        }
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer>arr = new ArrayList<>();
            for(int j=0;j<N;j++)
            {
                arr.add(grid[i][j]);
            }
            a.add(arr);
        }
        return a;
    }
}
