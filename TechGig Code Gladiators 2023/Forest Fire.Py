a,b = map(int,input().split())
animals = list(map(int, input().split()))

animals.sort(reverse=True)

count = 0
for i in range(a):
    if animals[i] >= animals[b-1]:
        count += 1
    else:
        break

if count == b:
    print(animals[b-1])
else:
    print("-1")
