n = int(input())

for i in range(n):
    A = int(input())
    set_a = set(input().split())
    b = int(input())
    set_b = set(input().split())
    subset = set_a.difference(set_b)
    if(len(subset))==0:
        print(True)
    else:
        print(False)