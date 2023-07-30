//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer>q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        
        //make new list to add level wise nodes
        ArrayList<Integer> bfs = new ArrayList<>();
        
        //initially starts with 0
        q.add(0);

        while(!q.isEmpty()){
            
            int curr = q.remove();

            if(!vis[curr]){//if not visited
                bfs.add(curr);//add and make it true
                vis[curr] = true;
                
                //now traverse the node and its neighbors and add them in q
                
                //use this or 
                for(int i=0; i<adj.get(curr).size(); i++){
                    int neighbor = adj.get(curr).get(i);
                    q.add(neighbor);
                }
                
                //or use advanced loop
                // for(Integer it : adj.get(curr)){
                //     q.add(it);
                // }
            }
            
        }
        
        return bfs;
    }
              }
