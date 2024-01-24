//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        boolean[] visited = new boolean[n];

    
    if(n == 1 && m>0){
        return false;
    }
    
    ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
    
    for(int i=0;i<n;i++){
        ed.add(new ArrayList<>());
    }
    
    for(int i=0;i<edges.size();i++){
        ed.get(edges.get(i).get(0)).add(edges.get(i).get(1));
                ed.get(edges.get(i).get(1)).add(edges.get(i).get(0));

    }
    
        if (hasCycle(ed, 0, -1, visited)) {
             //System.out.println(Arrays.toString(visited));

            return false;
        }

        // Check for disconnected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
              //  System.out.println("Visite Node" + i + visited[i]);
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> edges, int current, int parent, boolean[] visited) {
        visited[current] = true;


        for (int neighbor : edges.get(current)) {
            if (!visited[neighbor]) {
                if (hasCycle(edges, neighbor, current, visited)) {
                    return true;  // Cycle detected
                }
            }
            else if(neighbor == current){
                continue;
            }
            
            else if (neighbor != parent) {
                return true;  // Back edge detected
            }
        }

        return false;
    }
}

