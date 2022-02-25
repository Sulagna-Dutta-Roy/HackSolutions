import numpy

a, b, c = map(int, input().split())
A = numpy.array([input().split() for i in range(a)], int)
B = numpy.array([input().split() for i in range(b)], int)
print(numpy.concatenate((A, B), axis=0))
