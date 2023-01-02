class Solution {
    public int subsetXORSum(int[] nums) {
        int bits = 0;
        for (int i = 0; i < nums.length; i++)
          bits |= nums[i];
        int ans = bits * (int)Math.pow(2, nums.length-1);
        return ans;
    }
}
