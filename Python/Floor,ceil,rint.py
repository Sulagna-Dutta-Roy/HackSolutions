from tkinter import N
import numpy as np

A = np.array(input().split(), float)
np.set_printoptions(sign = ' ')

print(*[np.floor(A), np.ceil(A), np.rint(A)], sep = '\n')