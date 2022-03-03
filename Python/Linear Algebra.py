import numpy

A = int(input())
N = numpy.array([input().split() for _ in range(A)], float)
print(numpy.linalg.det(N).round(2))
