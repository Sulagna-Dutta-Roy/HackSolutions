class Solution:
    def countVowelPermutation(self, n: int) -> int:
        moduler = math.pow(10, 9) + 7
        a, e, i, o, u = [1] * 5
        for _ in range(n - 1):
            a, e, i, o, u = map(lambda x: x % moduler, [(e + i + u), (a + i), (e + o), (i), (i + o)])
        return int((a + e + i+ o + u) % moduler)
