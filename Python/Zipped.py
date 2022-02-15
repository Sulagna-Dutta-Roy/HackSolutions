a, x = map(int,input().split())
scores = [map(float, input().split()) for _ in range(x)]
[print(sum(student)/x) for student in zip(*scores)]