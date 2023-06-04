class Solution {
    private void dfs(int city,int[][] isConnected,boolean[] connect) {
       connect[city] = true;
       for(var i=0;i<isConnected.length;i++)
         if(isConnected[city][i]==1 && !connect[i])
           dfs(i,isConnected,connect);
    }
    public int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;
        var connect = new boolean[n];
        var count = 0;
        for(var i=0;i<n;i++) {
            if(!connect[i]) {
                dfs(i,isConnected,connect);
                count++;
            }
        }
        return count;
    }
}
