s = input()

sum = 0
for i in s:
    sum += ord(i)

sum //= len(s)

print(chr(sum))
