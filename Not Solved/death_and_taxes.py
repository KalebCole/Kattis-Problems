shares = 0; cost = 0; avg_cost = 0
while True:
    line = input().split(" ")
    if (line[0] == "buy"):
        shares += int(line[1])
        cost += int(line[1]) * int(line[2])
        avg_cost = cost/shares
    elif (line[0] == "sell"):
        shares -= int(line[1])
        cost -= int(line[1]) * avg_cost
    elif (line[0] == "split"):
        shares *= int(line[1])
        avg_cost /= int(line[1])
    elif (line[0] == "merge"):
        shares //= int(line[1])
        avg_cost *= int(line[1])
    elif (line[0] == "die"):
        gross_per_share = int(line[1]) - avg_cost
        if (gross_per_share < 0): 
            print(int(line[1]) * shares) # just print the amount after selling
        else: #taxed if profit
            net = shares * (int(line[1])-gross_per_share*.3)
            print(net)
        break