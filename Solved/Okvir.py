# get input
m, n = [int(num) for num in input().split(" ")]
u, l, r, d = [int(num) for num in input().split(" ")]
list = []
for _ in range(m):
    list.append(input())
    
# empty matrix the size of the board+frame
cols = l+r+n
rows = u+d+m
matrix = [[None] * cols for _ in range(rows)]
word = 0
index = 0

# top frame
for i in range(0, u):
    for j in range(0, l+r+n):
        if (i % 2 == 0 and j % 2 == 0 or i % 2 == 1 and j % 2 == 1): matrix[i][j] = "#"
        else: matrix[i][j] = "."


# board and left+right frame
for i in range(u, u+m):
    for j in range(0,l+r+n):
        if j < l or j >= l+n:
            if (i % 2 == 0 and j % 2 == 0 or i % 2 == 1 and j % 2 == 1): matrix[i][j] = "#"
            else: matrix[i][j] = "."
        else:
            matrix[i][j] = list[word][index]
            index+=1
            if(index >= n):
                index = 0
                word+=1

# bottom frame
for i in range(u+m, u+m+d):
    for j in range(0, l+r+n):
        if (i % 2 == 0 and j % 2 == 0 or i % 2 == 1 and j % 2 == 1): matrix[i][j] = "#"
        else: matrix[i][j] = "."
   
    
for row in matrix:
    print(''.join(str(element) for element in row))