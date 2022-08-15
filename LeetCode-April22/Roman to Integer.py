class Solution:
    def romanToInt(self, s: str) -> int:
        map = {"I":1, "V":5, "X":10, "L":50, "C":100, "D": 500, "M": 1000 }
        
        res, i = 0, 0
        while i < len(s)-1:
            if float(map[s[i]])/map[s[i+1]] == 0.2 or float(map[s[i]])/map[s[i+1]] == 0.1:
                res -= map[s[i]]
            else:
                res += map[s[i]]
            i += 1
        res += map[s[i]]
		
        return(res)
