nums = input().split()
s = int(nums[0])
c = int(nums[1])
k = int(nums[2])
socks = input().split()
socks.sort()

cycles = 0
count = 0
for i in range(1,s):
    if abs(int(socks[i]) - int(socks[i-1])) > k: 
        cycles+=1
        count = 0
    else: 
        count+=2
    if count >= c:
        cycles +=1
        count = 0
        
print(cycles)

        
    