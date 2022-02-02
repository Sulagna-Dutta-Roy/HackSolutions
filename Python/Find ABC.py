import math
AB,BC = int(input()),int(input())
hype = math.hypot(AB,BC)
res = round(math.degrees(math.acos(BC/hype)))
degree = chr(176)
print(res,degree, sep='')