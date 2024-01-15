public int solve(int i, int n, int total , int[]cost){
        if(i>=n)return 0;
        
        int notTake = solve(i+1, n, total, cost);
        int take = 0;
        if(total>=cost[i]){
            take = 1+solve(i+1, n, total-cost[i]+(int)(Math.floor((double)cost[i]*0.9)) , cost);
        }
        
        return Math.max(take, notTake);
    }
