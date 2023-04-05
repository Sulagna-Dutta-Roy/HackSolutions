class Solution {
    public int minimizeArrayValue(int[] nums) {
        double minMax = 0d;
        double numsSum = 0d;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
            double numsAverage = Math.ceil(numsSum / (i + 1));
            minMax = Math.max(minMax, numsAverage);
        }
        return (int) minMax;
    }
}
