class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        slen, tlen = len(stamp), len(target)
        res = []
        
        s_covers = set()
        for i in range(slen):
            for j in range(slen - i):
                s_covers.add('#' * i + stamp[i:slen-j] + '#' * j)
		
        done = '#' * tlen
		
        p = tlen - slen 
        while target != done:
            
            found = False
            for i in range(p, -1, -1):
                if target[i: i+slen] in s_covers:
                    target = target[:i] + '#' * slen + target[i+slen:]  
                    res.append(i)
                    found = True
            if not found:
                return []
        
        return res[::-1]
