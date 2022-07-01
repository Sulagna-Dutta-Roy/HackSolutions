class Solution:
    def minDeletions(self, s: str) -> int:
        frequencies = sorted(Counter(s).values(), reverse=True)
        
        total_deletions = 0
        next_unused_freq = len(s)
        for freq in frequencies:
            next_unused_freq = min(next_unused_freq, freq)
            total_deletions += freq - next_unused_freq
            if next_unused_freq > 0:
                next_unused_freq -= 1

        return total_deletions
