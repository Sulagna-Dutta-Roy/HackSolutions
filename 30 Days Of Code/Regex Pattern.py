import math
import os
import random
import re
import sys



if __name__ == '__main__':
    N = int(input().strip())
    nw = []

    for N_itr in range(N):
        first_multiple_input = input().rstrip().split()

        firstName = first_multiple_input[0]

        emailID = first_multiple_input[1]
        
        if '@gmail.com' in emailID:
            nw.append(firstName)
    
    nw=sorted(nw)
    for item in nw:
        print(item)
