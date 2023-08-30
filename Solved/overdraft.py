n = int(input())

sum = 0
max_deficit = 0
for i in range(n):
    sum += int(input())
    if sum < 0 and abs(max_deficit) < abs(sum):
        max_deficit = sum
        
print(abs(max_deficit))

    