from collections import OrderedDict
d = OrderedDict()
for _ in range(int(input())):
    items,space, quantity = input().rpartition(' ')
    d[items] = d.get(items, 0) + int(quantity)
for items, quantity in d.items():
    print(items, quantity)