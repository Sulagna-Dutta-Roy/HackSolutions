class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
         List<List<Integer>> l1 = new ArrayList<>();
         List<List<Integer>> l2 = new ArrayList<>();
         int[] ans = new int[n];
         Arrays.fill(ans,-1);
         for(int i = 0;i<n;i++){
             l1.add(new ArrayList<Integer>());
             l2.add(new ArrayList<Integer>());
         }
         for(int[] r : redEdges){
             l1.get(r[0]).add(r[1]);
         }
         for(int[] b : blueEdges){
             l2.get(b[0]).add(b[1]);
         }
         int f = 0;
         Queue<Pair<Integer,Integer>> q = new LinkedList<>();
         q.add(new Pair<>(0,0));
         q.add(new Pair<>(0,1));
         boolean[][] visited = new boolean[n][2];
         visited[0][1] = true;
         visited[0][0] = true;
         ans[0] = 0;
         int level = 1;
         while(!q.isEmpty()){
             int sz = q.size();
             System.out.println(sz);
             while(sz-->0){
                 Pair<Integer,Integer> curr = q.poll();
                 int value = curr.getKey();
                 int color = curr.getValue();
                 if(color==0){
                     for(int i : l1.get(value)){
                         if(!visited[i][0]){
                             q.add(new Pair<>(i,1));
                             if(ans[i]==-1)ans[i] = level;
                             visited[i][0] = true;
                         }
                     }
                 }
                 else{
                     for(int i : l2.get(value)){
                        if(!visited[i][1]){
                             q.add(new Pair<>(i,0));
                            if(ans[i]==-1) ans[i] = level;
                             visited[i][1] = true;
                         }
                     }
                 }
             }
             level++;
         }

        return ans;
    }
}
