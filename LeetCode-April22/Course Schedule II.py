class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        heap = []                            
        courses.sort(key = lambda x: x[1])   
        stime = 0
        for d, e in courses:
            heappush(heap, -d)               
            stime += d                      
            while stime > e:                 
                stime += heappop(heap)      
        return len(heap)