class Solution {
    public int maximumDetonation(int[][] bombs) {
        var G = new Graph(bombs);
        var cc = new CC(G);
        return cc.maxComponent();
    }
}

class Graph {

    private final List<Integer> [] adj;
    private final int V;

    Graph(int[][] bombs) {
        this.V = bombs.length;
        this.adj = new List[V];

        for (var v = 0; v < V; ++v)
            adj[v] = new ArrayList<Integer>();

        for (var v = 0; v < V - 1; ++v) {
            for (var w = v + 1; w < V; ++w) {
                if (isPointInside(bombs[v], bombs[w]))
                    adj[v].add(w);
                
                if (isPointInside(bombs[w], bombs[v]))
                    adj[w].add(v);
            }
        }
    }

    // w inside v
    private boolean isPointInside(int[] v, int[] w) {
        long xv = v[0], yv = v[1];
        long r = v[2];
        long xw = w[0], yw = w[1];
        return r * r >= (xv - xw) * (xv - xw) + (yv - yw) * (yv - yw);
    }

    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class CC {

    private final Graph G;
    private int max;

    CC(Graph G) {
        this.G = G;

        for (var v = 0; v < G.V(); ++v)
            max = Integer.max(max, dfs(new boolean[G.V()], v));
    }

    private int dfs(boolean[] marked, int v) {
        marked[v] = true;

        var c = 1;
        for (var w: G.adj(v)) {
            if (!marked[w])
                c += dfs(marked, w);
        }

        return c;
    }

    public int maxComponent() {
        return max;
    }
}   
