cells_per_lane = int(input())
lines = int(input())

total_empty = 0.0
for i in range(lines):
    line = list(input())
    total_empty += line.count(".")
    
print(total_empty / (cells_per_lane * lines))
    
    