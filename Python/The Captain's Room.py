from collections import Counter
rooms = input().split()
c = Counter(rooms)
print(c.most_common()[-1][0])