class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, zeroSubarray = 0;
        for (int n : nums) {
            if (n == 0) {
                count += ++zeroSubarray;
            }else {
                zeroSubarray = 0;
            }
        }
        return count;
    }
}
