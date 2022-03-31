class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        count, ans,diff = 0,0,None
        for i in range(1, len(nums)):
            newDiff = nums[i]-nums[i-1]
            if newDiff == diff:
                ans += count
                count += 1
            else:
                diff = newDiff
                count = 1
        return ans