class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        c = Counter(nums)
        output = 0
        seen = set()
        
        for x in c:
            if x not in seen and (k-x) in c:
                if x== (k-x):
                    output += c[x]//2
                else:
                    output += min(c[x], c[k-x])
                seen.add(x)
                seen.add(k-x)
        return output