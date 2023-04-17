line = list(input())

count = 0
for i in range(len(line)-1):
    if line[i] == ':' or line[i] == ';':
        if line[i+1] == ')':
            print(i)
        elif line[i+1] == '-' and i <= len(line)-2:
            if line[i+2] == ')':
                print(i)