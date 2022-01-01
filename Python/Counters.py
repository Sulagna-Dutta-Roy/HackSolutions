n = input()
shoes = map(int, raw_input().split())
orders = [map(int, raw_input().split()) for _ in range(input())]
results = 0
for i in orders:
    if i[0] in shoes:
        results += i[1]
        shoes.remove(i[0])

print(results)