class Solution {
    private List<Integer>[] adj;
    private int dfs(int id, int[] manager, int[] informTime) {
      var time = 0;
    for (var emp : adj[id])
      time = Math.max(time, dfs(emp, manager, informTime));

    return time + informTime[id];
  }
public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    adj = new ArrayList[n];

    for (var i=0; i<n; i++)
      adj[i] = new ArrayList<>();

    for (var i=0; i<n; i++) {
      if (i == headID) continue;
      adj[manager[i]].add(i);
    }
    return dfs(headID, manager, informTime);   
    }
}
