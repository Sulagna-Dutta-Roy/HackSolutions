n, m = raw_input().split()
n_elements = raw_input().split()

A = set(raw_input().split())
B = set(raw_input().split())

print sum([(i in A) - (i in B) for i in n_elements])