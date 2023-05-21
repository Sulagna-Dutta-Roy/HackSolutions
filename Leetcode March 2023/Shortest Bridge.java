class Solution {
   
    public int shortestBridge(int[][] grid) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int m = grid.length;
        int n = grid[0].length;
        //Mark one island as visited and add to queue
        boolean[][] visited = new boolean[m][n];

        boolean flag = false;
        Queue<int[]> qu = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){  
                if(grid[i][j] == 1){
                    dfs(i, j, visited, grid, dir, qu);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        int bridgeLen = 0;

        while(!qu.isEmpty()){
            int sz = qu.size();

            for(int i = 1; i <= sz; i++){
                int[] cell = qu.remove();

                for(int[] d: dir){
                    int rr = cell[0] + d[0];
                    int cc = cell[1] + d[1];

                    if(rr >= 0 && cc >= 0 && rr < m && cc < n && !visited[rr][cc]){
                        if(grid[rr][cc] == 1){
                            return bridgeLen;
                        }
                        visited[rr][cc] = true;
                        qu.add(new int[]{rr, cc});
                    }
                }
            }

            bridgeLen++;
        }

        return -1;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] grid, int[][] dir, Queue<int[]> qu){
        visited[r][c] = true;
        qu.add(new int[]{r, c});

        for(int[] d: dir){
            int rr = r + d[0];
            int cc = c + d[1];

            if(rr >= 0 && cc >= 0 && rr < grid.length && cc < grid[0].length && grid[rr][cc] == 1 && !visited[rr][cc]){
                dfs(rr, cc, visited, grid, dir, qu);   
            }
   
        }  
    }
}
