import sys

for line in sys.stdin:
    start = 0
    end = 0
    count = 0
    output = ""
    for i in range(len(line)):
        if line[start] == line[i]: #not new
            count += 1
            end += 1
        else: #we have a new letter 
            end = i
            output += str(end-start) + line[start]
            start = end
    print(output)

        
    
    