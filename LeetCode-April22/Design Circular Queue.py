class MyCircularQueue:

    def __init__(self, k: int):
        self.queue = [0]*k
        self.start = 0
        self.end = 0
        self.k = k
        
    def enQueue(self, value: int) -> bool:
        if self.isFull(): return False 
        self.queue[self.end % self.k] = value
        self.end += 1
        return True

    def deQueue(self) -> bool:
        if self.isEmpty(): return False 
        self.start += 1
        return True

    def Front(self) -> int:
        if self.isEmpty(): return -1
        return self.queue[self.start % self.k]

    def Rear(self) -> int:
        if self.isEmpty(): return -1
        return self.queue[(self.end-1)%self.k]

    def isEmpty(self) -> bool:
        return self.start == self.end

    def isFull(self) -> bool:
        return self.end == self.start+self.k
        


# Your MyCircularQueue object will be instantiated and called as such:
obj = MyCircularQueue(k)
param_1 = obj.enQueue(value)
param_2 = obj.deQueue()
param_3 = obj.Front()
param_4 = obj.Rear()
param_5 = obj.isEmpty()
param_6 = obj.isFull()
