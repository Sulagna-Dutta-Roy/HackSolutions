for i in range(int(input())):
    try:
        a, b = map(int, input().split())
        print(a//b)
    except BaseException as e:
        print('Error Code:',e)
