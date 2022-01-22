a,b = (int(input()),input().split())
c, d = (int(input()), input().split())
x = set(b)
y = set(d)

p = y.difference(x)
q = x.difference(y)

r = p.union(q)
print('\n'.join(sorted(r, key=int)))