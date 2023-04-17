n = int(input())

num = ''
for i in range(n):
    num += input() + ' '


list = num.split(' ')
list.pop()
list.reverse()

print(*list, sep = '\n')
    

