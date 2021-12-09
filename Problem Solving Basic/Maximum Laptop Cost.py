def maxCost(cost, labels, dailyCount):
    # Write your code here
    max_cost = 0
    produce = 0
    daily_cost = 0
    for c, l in zip(cost, labels):
        daily_cost += c
        if l == 'legal':
            produce += 1

        if produce == dailyCount:
            max_cost = max(max_cost, daily_cost)
            daily_cost = 0
            produce = 0
    return max_cost


if _name_ == '_main_':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    cost_count = int(raw_input().strip())

    cost = []

    for _ in xrange(cost_count):
        cost_item = int(raw_input().strip())
        cost.append(cost_item)

    labels_count = int(raw_input().strip())

    labels = []

    for _ in xrange(labels_count):
        labels_item = raw_input()
        labels.append(labels_item)

    dailyCount = int(raw_input().strip())

    result = maxCost(cost, labels, dailyCount)

    fptr.write(str(result) + '\n')

    fptr.close()