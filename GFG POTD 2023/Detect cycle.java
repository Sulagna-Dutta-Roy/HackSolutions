//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean aj[] = new boolean[V];
        for(int i = 0 ; i < V;i++)
        {
            if(!aj[i]  && dfs(i,adj,aj,-1))
            {
                
                    return 1;
            }
        }
        return 0;
    }
    public boolean dfs(int i , ArrayList<ArrayList<Integer>> adj,boolean[] aj,int parent){
        aj[i] = true;
        for(Integer ne : adj.get(i))
        {
         if(!aj[ne])
         {
             if(dfs(ne,adj,aj,i))
             return true;
         }
         else if(ne != parent)
         {
             return true;
             
         }
    }
    return false;
    }
}
