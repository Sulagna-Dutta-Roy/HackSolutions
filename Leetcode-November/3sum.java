class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>(0);
        Arrays.sort(nums);//O(nlgn)
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], i);
        List<List<Integer>> res = new ArrayList<>(); 
        for (int i = 0; i<nums.length-2; i++) {
            for(int j = i+1; j<nums.length-1;j++){
                int check = -nums[i]-nums[j];
                int index = map.getOrDefault(check, -1);
                if(index>j){
                    res.add(Arrays.asList(nums[i], nums[j], check));
                }
                while(j<nums.length-1 && nums[j]==nums[j+1]) j++;
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
