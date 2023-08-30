row, column = [int(x) for x in input().split(" ")]
count = 1
matrix = []
for i in range(row):
    matrix.append(list(input()))

# check whole column to see if they are all blanks
for i in range(column):
    isEmpty = True
    for j in range(row):
        temp = matrix[j][i]
        if matrix[j][i] == "$":
            isEmpty = False
            break
    if isEmpty: count+=1
        
print(count)