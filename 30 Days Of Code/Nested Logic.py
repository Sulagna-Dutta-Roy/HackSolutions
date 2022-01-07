d,m,y = map(int,list(input().split(' ')))
de,me, ye = map(int, list(input().split(' ')))

fine = 0

if y > ye:
    fine = 10000
elif y == ye:
    if m > me:
        fine = 500 * (m - me)
    elif m == me:
        if d > de:
            fine = 15* (d-de)

print(fine)