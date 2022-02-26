N = int(input())
A = input().split()

if all(int(i) >= 0 for i in A):
    if any(num == num[-1:] for num in A):
        print('True')
    else:
        print('False')

else:
    print('False')
        