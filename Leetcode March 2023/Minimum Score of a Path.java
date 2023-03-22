class Solution {
    private int[] root, node;
    
    private int find(int x){
        if(x == root[x])
            return root[x];
        return root[x] = find(root[x]);
    }
    
    private void createUnion(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY)
            return;
        if(node[rootX] < node[rootY])
            node[rootX] = rootY;
        else if(node[rootX] > node[rootY])
            root[rootY] = rootX;
        else{
            root[rootY] = rootX;
            node[rootX]++;
        }
    }
    
    public int minScore(int n, int[][] roads) {
        root = new int[n + 1];
        node = new int[n + 1];
        for(int i = 0; i < n; i++){
            root[i] = i;
            node[i] = 0;
        }
        int minScore = Integer.MAX_VALUE;
        for (int[] road : roads) {
            createUnion(road[0], road[1]);
        }
        for (int[] road : roads) {
            int root1 = find(1);
            int rootX = find(road[0]);
            int rootY = find(road[1]);
            if (root1 == rootX && root1 == rootY) {
                minScore = Math.min(minScore, road[2]);
            }
        }
        return minScore;
    }
}
