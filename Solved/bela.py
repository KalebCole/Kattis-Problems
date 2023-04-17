temp = input().split(' ')

n = int(temp[0])
b = temp[1]

value = 0
sum = 0
for i in range(4*n):
    temp = input()
    num = temp[0]
    suit = temp[1]
    if suit == b:
        if num == 'J':
            value = 20
        elif num == '9':
            value = 14
    else:
        if num == 'J':
            value = 2
        elif num == '9':
            value = 0
    if num == 'A':
        value = 11
    elif num == 'K':
        value = 4
    elif num == 'Q':
        value = 3
    elif num == 'T':
         value = 10
    elif num == '8':
         value = 0
    elif num == '7':
        value = 0
    sum += value

print(sum) 
