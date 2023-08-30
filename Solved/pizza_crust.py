import math
r, c = [int(x) for x in input().split(" ")]

if c == r: print(0); quit()
print((math.pi*((r-c)**2))/(math.pi*(r**2))*100)