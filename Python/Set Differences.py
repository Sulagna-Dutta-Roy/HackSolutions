n1 = int(input())
set_1 = set(map(int, input().split()))
n2 = int(input())
set_2 = set(map(int, input().split()))
print(len(set_1 | set_2))


n1 = int(input())
set_1 = set(map(int, input().split()))
n2 = int(input())
set_2 = set(map(int, input().split()))
print(len(set_1 & set_2))


n1 = int(input())
set_1 = set(map(int, input().split()))
n2 = int(input())
set_2 = set(map(int, input().split()))
print(len(set_1 - set_2))