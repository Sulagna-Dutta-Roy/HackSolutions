class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int min = nums[0]*2;
        for(int i = 0;i<n;i++){
            if(nums[i]%2!=0) nums[i]*=2;
            pq.add(nums[i]);
            min = Math.min(nums[i], min);
        }
        
        int ans = pq.peek()-min;
        while (pq.peek()%2==0){
            int top = pq.poll();
            pq.add(top/2);
            ans = Math.min(ans, top - min);
            min = Math.min(min,top/2);
        }
        return Math.min(ans,pq.peek()-min) ;
    }
}
