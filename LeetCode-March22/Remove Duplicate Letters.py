class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack = {}
        for i in range(len(s)):
            stack[s[i]] = i
            
        st = []
        seen = set()
        
        for i in range(len(s)):
            if s[i] in seen:
                continue
            while st and st[-1] > s[i] and stack[st[-1]] > i:
                seen.remove(st[-1])
                st.pop()
                
            st.append(s[i])
            seen.add(s[i])
            
        return "".join(st)