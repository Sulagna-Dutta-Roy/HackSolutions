import re
number = r'^[789]\d{9}$'

for _ in range(int(input())):
    n = re.match(number, input())
    if n:
        print('YES')
    else:
        print('NO')
