n = int(input())
balance = 0
min_balance = 0
for _ in range(n):
    m = int(input())
    balance += m
    min_balance = max(-balance, min_balance)
print(min_balance)