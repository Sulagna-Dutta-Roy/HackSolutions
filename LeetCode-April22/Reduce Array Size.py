class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        total_len = len(arr)
        target_len = total_len // 2
        counter = 0
        arr_chr_count = Counter(arr).most_common()
        for x in arr_chr_count:
            total_len -= x[1]
            counter += 1
            print(counter)
            if total_len <= target_len:
                break

        return counter
