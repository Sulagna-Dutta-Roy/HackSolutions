import re 

for _ in range(int(input().strip())):
    try:
        re.match(input(), '')
        print("True")
    except:
        print("False")