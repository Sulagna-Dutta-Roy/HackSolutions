import numpy

N = int(input())

A = numpy.array([input().split() for i in range(N)], int)
B = numpy.array([input().split() for i in range(N)], int)

m = numpy.dot(A, B)
print(m)