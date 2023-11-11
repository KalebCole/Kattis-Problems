words = []
sum = 0
# get input
while True:
    try:
        sentence = input()
        words.append(sentence)
    except EOFError:
        break
    
# find max length
max = -1
for word in words:
    if len(word) > max:
        max = len(word)

# add up the points
for i, word in enumerate(words):
    if i == len(words)-1:
        break
    sum += (max-len(word))**2
    
print(sum)