n = int(input())



for i in range(n):
    sum = 0
    rank = 0
    ranks = []
    input()
    k = int(input())
    for j in range(k):
        rank = int(input().split(' ')[1])
        ranks.append(rank)
    ranks.sort()
    for l in range(k):
        sum += abs((l+1) - ranks[l])
    print(sum)

    
        