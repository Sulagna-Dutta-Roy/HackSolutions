class Solution {
    public boolean containsDuplicate(int[] nums) {
        return nums.length != IntStream.of(nums).distinct().count();
    }
}
