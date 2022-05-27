class Solution:
    def hammingWeight(self, n: int) -> int:
        return str("{0:b}".format(n)).count('1') 