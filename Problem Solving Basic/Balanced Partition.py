def mostBalancedPartition(parent, files_size):
    # Write your code here
    n = len(parent)
    main_sum = [0 for i in xrange(n)]
    for i in xrange(0, n):
        temp = i
        while (temp != -1):
            main_sum[temp] += files_size[i]
            temp = parent[temp]
    min_sum = abs(main_sum[0] - 2 * main_sum[1])
    for i in xrange(2, n):
        if min_sum > abs(main_sum[0] - 2 * main_sum[i]):
            min_sum = abs(main_sum[0] - 2 * main_sum[i])
    return min_sum


if _name_ == '_main_':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    parent_count = int(raw_input().strip())

    parent = []

    for _ in xrange(parent_count):
        parent_item = int(raw_input().strip())
        parent.append(parent_item)

    files_size_count = int(raw_input().strip())

    files_size = []

    for _ in xrange(files_size_count):
        files_size_item = int(raw_input().strip())
        files_size.append(files_size_item)

    result = mostBalancedPartition(parent, files_size)

    fptr.write(str(result) + '\n')

    fptr.close()