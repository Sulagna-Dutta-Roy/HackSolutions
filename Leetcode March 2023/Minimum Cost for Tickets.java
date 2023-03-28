class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] ab = new int[n + 1];
        Arrays.fill(ab, Integer.MAX_VALUE);
        ab[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            ab[i] = ab[i - 1] + costs[0];
            
            int j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 7) j--;
            ab[i] = Math.min(ab[i],ab[j + 1] + costs[1]);
            
            j = i - 1;
            while (j >= 0 && days[i - 1] - days[j] < 30) j--;
            ab[i] = Math.min(ab[i], ab[j + 1] + costs[2]);
        }
        
        return ab[n];
    }
}
