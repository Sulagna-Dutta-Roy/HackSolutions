//{ Driver Code Starts
//Initial Template for Java

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
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        return getBridges(adj, v);
    }
    
    public ArrayList<ArrayList<Integer>> getBridges(ArrayList<ArrayList<Integer>>adj, int v){
        int[]dt = new int[v];
        int[]low = new int[v];
        boolean[]vis = new boolean[v];
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        
        dfs(adj, vis, dt, low, 0, -1,ans);
    
        Collections.sort(ans, (a,b)->{
            if(a.get(0).equals(b.get(0))){
                return a.get(1)-b.get(1);
            }else{
                return a.get(0)-b.get(0);
            }
        });
        
        return ans;
    }
    int time = 0;
    public void dfs(ArrayList<ArrayList<Integer>>adj, boolean[]vis, int[]dt, int[]low, int curr, int parent, ArrayList<ArrayList<Integer>>ans){
        vis[curr] = true;
        
        dt[curr] = low[curr] = ++time;
        
        for(int node : adj.get(curr)){
            if(node == parent)continue;
            
            if(!vis[node]){
                dfs(adj, vis, dt,low, node, curr, ans);
                low[curr] = Math.min(low[curr], low[node]);
                
                // bridge condition
                if(low[node]>dt[curr]){
                    ArrayList<Integer>bridge = new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(node);
                    Collections.sort(bridge);
                    ans.add(bridge);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[node]);
            }
        }
    }
}
