import numpy

numpy.set_printoptions(sign = ' ')
N, M = map(int, input().split())
print(numpy.eye(N,M, k=0))