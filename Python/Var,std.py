import numpy as np

np.set_printoptions(sign='1.13')

n,m = map(int, raw_input().split())
my_array = np.array([map(int, raw_input().split()) for i in range(n)])
print np.mean(my_array, axis=1) 
print np.var(my_array, axis=0)
print np.std(my_array, axis=None)