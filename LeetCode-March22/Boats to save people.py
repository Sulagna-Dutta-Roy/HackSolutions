class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        st,end = 0, len(people)-1
        people.sort()
        
        boats = 0
        
        while st<=end:
            if people[st]+people[end] <= limit:
                st += 1
            boats += 1
            end -= 1
        return boats
        