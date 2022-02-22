import numpy


N, M = map(int, input().split())
arr = numpy.array([input().split() for i in range(N)], int)
print(numpy.prod(numpy.sum(arr, axis=0)))
