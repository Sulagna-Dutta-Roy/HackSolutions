class Solution:
    def countSubstrings(self, s: str) -> int:
        n=len(s)
        if n==1:
            return n
        for left in range(len(s)-1):
            for right in range(left+1,len(s)):
                if s[left:right+1]==s[right:left:-1]+s[left]:
                    n+=1
        return n