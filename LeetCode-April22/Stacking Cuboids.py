class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda x: (-x[0], x[1]))
        max_defense = 0
        weak_count = 0
        for _, defense in properties:
            if defense < max_defense:
                weak_count += 1
            else:
                max_defense = defense
        return weak_count
