p1 = input()
p2 = input()
exponent = 0
for i in range(4):
    if p1[i] != p2[i]:
        exponent += 1

print(2**exponent)