# Enter your code here. Read input from STDIN. Print output to STDOUT
from collections import deque
d = deque()

for i in range(int(input())):
    method, *n = input().split()
    getattr(d, method)(*n)
print(*d)