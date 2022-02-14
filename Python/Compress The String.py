from itertools import groupby
List = input()
for c, items in groupby(List):
    print(tuple([len(list(items)), int(c)]), end = ' ')