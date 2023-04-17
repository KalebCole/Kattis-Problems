n, k = input().split()
n = int(n)
k = int(k)

judges_left = n-k
sum = 0
for i in range(k):
    r = int(input())
    sum += r
print((sum+(judges_left*(-3)))/n, (sum+(judges_left*(3)))/n)
    