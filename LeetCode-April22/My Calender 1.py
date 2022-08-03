class MyCalendar:

    def __init__(self):
        self.booked = []

    def book(self, start: int, end: int) -> bool:
        if self.check_booking(start, end):
            self.booked.append([start, end])
            return True
        return False
    
    def check_booking(self, start, end):
        for x,y in self.booked:
            if( start >= x and start < y) or (end > x and end <=y):
                return False
            if x > start and y < end:
                return False
        return True


# Your MyCalendar object will be instantiated and called as such:
obj = MyCalendar()
param_1 = obj.book(start,end)
