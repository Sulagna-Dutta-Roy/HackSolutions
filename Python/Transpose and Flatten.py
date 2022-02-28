import numpy

n, m = map(int, input().split())
my_arr = numpy.array([input().strip().split() for _ in range(n)], int)
print(my_arr.transpose())
print(my_arr.flatten())