class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
      int n = nums1.length;
        int[][] nums2Indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums2Indexed[i] = new int[]{nums2[i], i};
        }
        Arrays.sort(nums2Indexed, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long su = 0;
        for (int i = 0; i < k; i++) {
            int index = nums2Indexed[i][1];
            int val = nums1[nums2Indexed[i][1]];
            su += val;
            pq.offer(val);
        }
        long res = su * nums2Indexed[k - 1][0];
        for (int i = k; i < n; i++) {
            int index = nums2Indexed[i][1];
            int val = nums1[nums2Indexed[i][1]];
            if (val <= pq.peek()) continue;
            su -= pq.remove();
            pq.offer(val);
            su += val;
            res = Math.max(res, su * nums2Indexed[i][0]);
        }
        return res;
    }
 }
