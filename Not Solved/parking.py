# Need to specify within the actual range, not just in the list

a,b,c = [int(x) for x in input().split(" ")]
a_range = [int(x) for x in input().split(" ")]
b_range = [int(x) for x in input().split(" ")]
c_range = [int(x) for x in input().split(" ")]

index = 1
sum = 0
while True:
    if index not in a_range or b_range or c_range:
        break
    if index in a_range:
        sum+=a
    if index in b_range:
        sum+=b
    if index in c_range:
        sum+=c
    index += 1
    
print(sum)

