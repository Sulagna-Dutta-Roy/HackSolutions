class KthLargest {
    private PriorityQueue<Integer> h;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        h = new PriorityQueue<>(k);
        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(h.size()<k) {
            h.offer(val);
        }
        else if (val > h.peek()) {
            h.poll();
            h.offer(val);
        }
    return h.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
