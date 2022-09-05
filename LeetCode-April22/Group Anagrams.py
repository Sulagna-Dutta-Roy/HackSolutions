class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        grouped_ana=defaultdict(list)
        for s in strs:
            s_sort=str(sorted(s))
            grouped_ana[s_sort].append(s)

        return grouped_ana.values()
