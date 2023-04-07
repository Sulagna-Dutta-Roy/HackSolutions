class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = 0;
        int l = nums.length;
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            ans[i] = n;
            n += nums[i];
        }

        n = 0;

        for (int i = l-1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - n);
            n += nums[i];
        }

        return ans;
    }
}
