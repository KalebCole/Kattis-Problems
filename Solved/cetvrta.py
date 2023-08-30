x_coords = set()
y_coords = set()

line = []
for _ in range(3):
    line = input().split(" ")
    if line[0] in x_coords:
        x_coords.remove(line[0])
    else:
        x_coords.add(line[0])
    if line[1] in y_coords:
        y_coords.remove(line[1])
    else:
        y_coords.add(line[1])
    
print(f"{x_coords.pop()} {y_coords.pop()}")
