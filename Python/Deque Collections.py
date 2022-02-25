from collections import deque
d = deque()

for i in range(int(input())):
    a = input().split()
    if a[0]=='append':
        d.append(a[1])
    elif a[0]=='appendLeft':
        d.appendLeft(a[1])
    elif a[0]=='pop':
        d.pop()
    elif a[0]=='popLeft':
        d.popLeft()

print(*d)