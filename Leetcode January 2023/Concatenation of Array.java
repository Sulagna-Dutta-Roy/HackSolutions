class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans = nums.length;
        int arr[] = new int[2*ans];
        for(int i=0;i<ans;i++) {
            arr[i]= nums[i];
            arr[i+ans] = nums[i];
        }
    return arr;
    }
}
