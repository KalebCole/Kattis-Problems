def checkHours(arr):
    temp = ''
    for i in range(0, len(arr)): # bubble sort :(
        for j in range(1, len(arr)):
            print(arr[j][ :arr[j].index(':')])
            print(arr[j-1][ :arr[j].index(':')])
            print(arr[j][arr[j].index(':'): ])
            print(arr[j-1][arr[j].index(':'): ])
            if int(arr[j][0:arr[j].index(':')]) < int(arr[j-1][0:arr[j].index(':')]): #check hours
                temp = arr[j]
                arr[j] = arr[j-1]
                arr[j-1] = temp
            elif int(arr[j][0:arr[j].index(':')]) == int(arr[j][0:arr[j].index(':')]): #if hours are equal
                  if(int(arr[j][arr[j].index(':')]) > int(arr[j-1][1])): # check minutes
                      temp = arr[j]
                      arr[j] = arr[j-1]
                      arr[j-1] = temp
                    #we do not care if they are equal
    return arr #sorted the array
            
        
    
            

n = int(input())

time = []

AM_arr = []
PM_arr = []
for _ in range(n):
    time = input().split()
    if time[1] == "a.m.": AM_arr.append(time[0])
    else: PM_arr.append(time[0])
AM_arr = checkHours(AM_arr)
PM_arr = checkHours(PM_arr)

for i in AM_arr:
    print(i, "a.m.")
for i in PM_arr:
    print(i,"p.m.")

