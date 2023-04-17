n = int(input())
prev = input()
curr = ''
isFair = True
words = {prev}
for i in range(1,n): #starting from 1 because we already have the first word store in 'prev'
    curr = input()
    if prev[-1] != curr[0] or curr in words:
        if i%2 != 1: print('Player 1 Lost') #since we start with the second person's word
        else: print('Player 2 Lost')
        isFair = False
        break
    words.add(prev)
    prev = curr
    
if isFair: print('Fair Game')