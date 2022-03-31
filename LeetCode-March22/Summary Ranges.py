class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n = len(nums)
        i=0
        res = []
        while i < n:
            e = '{}'.format(nums[i])
            a = nums[i]
            while i + 1 < n and nums[i] + 1 == nums[i+1]:
                i = i+1
            if a != nums[i]:
                res.append(e+'->'+'{}'.format(nums[i]))
            else:
                res.append(e)
            i = i + 1
        return res