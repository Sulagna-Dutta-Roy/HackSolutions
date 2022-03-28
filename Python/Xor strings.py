def strings_xor(s, t):
    res = ""
    for i in range(len(s)):
        if bool(1-int(s[i])^int(t[i])):
            res += '0'
        else:
            res += '1'

    return res

s = input()
t = input()
print(strings_xor(s, t))