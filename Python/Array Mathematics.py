import numpy

N, M = map(int, input().split())
A,B = (numpy.array([input().split() for _ in range(N)], dtype=int) for _ in range(2))
print(A+B, A-B, A*B, A//B, A%B, A**B, sep='\n')