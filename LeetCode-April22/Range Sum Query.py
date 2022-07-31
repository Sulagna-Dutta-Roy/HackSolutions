class NumArray(object):
    nums = []
    s=0
    l=0
    def __init__(self, nums):
        self.nums=nums
        self.s=sum(nums)
        self.l=len(nums)

    def update(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        self.s -= self.nums[index]
        self.nums[index]=val
        self.s += self.nums[index]
        
    def sumRange(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: int
        """
        if right - left > self.l // 2:
            ans = sum(self.nums[:left])+sum(self.nums[right+1:])
            return self.s - ans
        else:
            return sum(self.nums[left: right+1])


# Your NumArray object will be instantiated and called as such:
obj = NumArray(nums)
obj.update(index,val)
param_2 = obj.sumRange(left,right)
