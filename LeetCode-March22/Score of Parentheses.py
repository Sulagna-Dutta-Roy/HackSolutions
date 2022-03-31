class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        pwr, ans = 0, 0
        for i in range(1, len(s)):
            if s[i] == "(": 
                pwr += 1
            elif s[i-1] == "(":
                ans += 1 << pwr
                pwr -= 1
            else: pwr -= 1
        return ans