class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        ans = []
        for word in words:
            mapping = {}
            pattern_char_used = set()
            ans.append(word)
            for word_char, pattern_char in zip(word, pattern):

                if word_char in mapping and mapping[word_char] != pattern_char:
                    ans.pop()
                    break
                if pattern_char in pattern_char_used and (word_char not in mapping or mapping[word_char] != pattern_char):
                    ans.pop()
                    break
                mapping[word_char] = pattern_char
                pattern_char_used.add(pattern_char)
        
        return ans
