def print_rangoli(size):
    # your code goes here
    import string 
    alphabets = string.ascii_lowercase
    
    N = []
    for i in range(n):
        s = "-".join(alphabets[i:n])
        N.append((s[::-1]+s[1:]).center(4*n-3, "-"))
    
    print('\n'.join(N[:0:-1]+N))

if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)