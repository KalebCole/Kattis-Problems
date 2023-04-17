n = int(input())
nums = input().split()

arr = [None]*(n-1)
for i in range(n-1):
    arr[int(nums[i])] = i+2

print(1,end=' ')
for i in arr:
    print(i,end=' ')