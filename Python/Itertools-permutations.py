from itertools import permutations


s, k = input().split(" ")
p = list(permutations(s, int(k)))
p.sort()

for i in p:
    print("".join(i))