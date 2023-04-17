n = input()

temps = input().split(' ')

count = 0
for temp in temps:
    if int(temp) < 0:
        count += 1

print(count)