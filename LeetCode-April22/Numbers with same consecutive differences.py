class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        result = []
        if n == 1 : result.append(0)
            
        def dfs(num , n):
            if n == 0:
                result.append(num)
                return
            last_digit = num % 10
            if last_digit >= k : dfs(num * 10 + last_digit - k , n -1)
            if k > 0 and last_digit + k < 10 : dfs(num * 10 + last_digit + k ,n -1)
                
                
        for d in range(1 , 10):
            dfs(d , n- 1  )
        return result
