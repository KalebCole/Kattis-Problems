# SORT THE SOCKS AND SEE THE DIFFERENCES FROM IT

socks, cap, diff = input().split(" ")
socks = int(socks)
cap = int(cap) 
diff = int(diff)
queue = [int(n) for n in input().split(" ")]
sum = 1

in_wash = 0 # amt of socks in the washer 
prev = -1
curr = -1
for _ in range(socks):
    curr = queue.pop(0)
    if in_wash > cap:
        sum+=1
        prev = curr
        in_wash = 1
        continue
    
    if prev == -1 or abs(prev-curr) <= diff: # if the first element or not out of bounds
        prev = curr
        in_wash += 1
        continue
    sum += 1
    prev = curr
    in_wash = 1
        
  
print(sum)  
         
    