sides = int(input())
up_from_bottom = sides

for i in range(3, sides, 2):
    print(f"i:{i}")
    if i == sides:
        break
    up_from_bottom -= 1

print(up_from_bottom)
