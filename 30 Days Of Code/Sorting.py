#!/bin/python3

import math
import os
import random
import re
import sys



if __name__ == '__main__':
    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    # Write your code here
    
    swaps = 0
    sort = False
    
    while not sort:
        sort = True
        i = 0
        for i in range(0,len(a)):
            if i<len(a)-1:
                if a[i]>a[i+1]:
                    a[i], a[i+1] = a[i+1],a[i]
                    sort = False
                    swaps += 1
    print('Array is sorted in {} swaps.'.format(swaps))
    print('First Element: {}'.format(a[0]))
    print('Last Element: {}'.format(a[len(a)-1]))
