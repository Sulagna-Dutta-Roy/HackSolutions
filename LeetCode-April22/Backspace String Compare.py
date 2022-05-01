class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        s_stack, t_stack = [], []
        for ch in s:
            if ch == "#":
                if s_stack:
                    s_stack.pop()
            else:
                s_stack.append(ch)
        for ch in t:
            if ch == "#":
                if t_stack:
                    t_stack.pop()
            else:
                t_stack.append(ch)
        return "".join(s_stack)=="".join(t_stack)