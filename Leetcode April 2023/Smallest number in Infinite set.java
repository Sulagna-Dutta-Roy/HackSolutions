class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int smallest;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        smallest = 1;
    }

    public int popSmallest() {
        if (pq.isEmpty()) {
            return smallest++;
        }
        set.remove(pq.peek());
        return pq.poll();

    }

    public void addBack(int num) {
        if (smallest > num) {
            int sizeprev = set.size();
            set.add(num);
            if (sizeprev < set.size()) {
                pq.add(num);
            }
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
