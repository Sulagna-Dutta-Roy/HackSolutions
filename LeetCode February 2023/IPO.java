class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int maxCapital = 0;
        for (int i = 0; i < capital.length; i++) {
            maxCapital = Math.max(capital[i], maxCapital);
        }

        if (w >= maxCapital) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
            for (int p : profits) {
                maxHeap.add(p);
                if (maxHeap.size() > k) maxHeap.poll();
            }
            for (int h : maxHeap) w += h;
            return w;
        }

        int index;
        int n = profits.length;
        for (int i = 0; i < Math.min(k, n); i++) {
            index = -1;
            for (int j = 0; j < n; ++j) {
                if (w >= capital[j] && (index == -1 || profits[index] < profits[j])) {
                    index = j;
                }
            }
            if (index == -1) break;
            w += profits[index];
            capital[index] = Integer.MAX_VALUE;
        }
        return w;
    }
}
