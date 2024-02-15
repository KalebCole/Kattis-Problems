word = input()
count = 0
num_of_y = 0
for letter in word:
    if(letter == "a" or letter == "e" or letter == "i" or letter == "o" or letter == "u"):
        count += 1
    elif(letter == "y"):
        num_of_y += 1

print(count, count+num_of_y)