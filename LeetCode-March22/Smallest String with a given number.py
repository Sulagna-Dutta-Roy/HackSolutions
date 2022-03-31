class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        if n*26 == k:
            return 'z'*n
        k -= n
        nz = k // 25
        na = n-nz-1
        
        return na*'a'+chr(ord('a')+k%25)+nz*'z'