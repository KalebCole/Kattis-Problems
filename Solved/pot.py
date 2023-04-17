def pot():
    n = int(input())
    sum = 0
    term = 0
    line = 0
    eponenet = 0
    for i in range(n):
        line = int(input())
        term = line // 10
        sum += (term ** (line % 10))

    print(sum)
pot()