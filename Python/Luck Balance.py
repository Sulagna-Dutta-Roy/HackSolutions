#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'luckBalance' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. 2D_INTEGER_ARRAY contests
#

def luckBalance(k, contests):
    # Write your code here
    balance = 0
    is_important = []
    for i in range(n):
        li, ti = contests[i]
        if ti ==0:
            balance += li
        else:
            is_important.append(li)
    is_important.sort()
    if len(is_important)>k:
        for i in range(len(is_important)-k):
            balance -= is_important[i]
        for i in range(len(is_important)-k, len(is_important)):
            balance += is_important[i]
    elif len(is_important)<=k:
        for i in range(len(is_important)):
            balance += is_important[i]
    return balance

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()
