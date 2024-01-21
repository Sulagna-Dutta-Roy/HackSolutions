//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            // Adjusting 1-based indexing to 0-based
            graph[edge[0] - 1][edge[1] - 1] = true;
            graph[edge[1] - 1][edge[0] - 1] = true;
        }

        boolean[] visited = new boolean[n];
        int minCoverSize = n;  // Start with the maximum possible size

        minCoverSize = findMinCover(graph, visited, 0, 0, minCoverSize);

        return minCoverSize;
    }

    private static int findMinCover(boolean[][] graph, boolean[] visited, int start, int size, int minCoverSize) {
        if (start == graph.length) {
            if (isVertexCover(graph, visited) && size < minCoverSize) {
                minCoverSize = size;
            }
            return minCoverSize;
        }

        // Don't include the current vertex in the cover
        minCoverSize = findMinCover(graph, Arrays.copyOf(visited, visited.length), start + 1, size, minCoverSize);

        // Include the current vertex in the cover
        visited[start] = true;
        minCoverSize = findMinCover(graph, Arrays.copyOf(visited, visited.length), start + 1, size + 1, minCoverSize);

        return minCoverSize;
    }

    private static boolean isVertexCover(boolean[][] graph, boolean[] visited) {
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph[u].length; v++) {
                if (graph[u][v] && !(visited[u] || visited[v])) {
                    return false;
                }
            }
        }
        return true;
    }
}
        
