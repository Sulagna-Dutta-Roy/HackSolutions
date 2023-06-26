class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
      int m =0;
      int n = costs.length-1;
      PriorityQueue<Integer> pq1 = new PriorityQueue<>();
      PriorityQueue<Integer> pq2 = new PriorityQueue<>();
      long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && m <= n) {
                pq1.offer(costs[m++]);
            }
            while (pq2.size() < candidates && m <= n) {
                pq2.offer(costs[n--]);
            }

            int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                pq1.poll();
            } else {
                ans += t2;
                pq2.poll();
            }
        }
        return ans;
    }
}
