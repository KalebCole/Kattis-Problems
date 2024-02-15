empty, found, cost = [int(x) for x in input().split()]

total_empty = empty+found
count = 0

if total_empty < cost:
    print(0)
else:
    while total_empty >= cost:
        total_empty -= cost
        total_empty += 1 # bought a new one and drank it
        count += 1
    print(count)   

