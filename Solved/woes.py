def firstMultipleGreaterThan(factor, num):
    while(factor < num):
        factor += factor
    return factor

s,t,n = [int(x) for x in input().split(" ")]
drop_off_walk = [int(x) for x in input().split(" ")]
time_of_bus = [int(x) for x in input().split(" ")]
bus_arrival = [int(x) for x in input().split(" ")]

time = 0
i = 0
while(i < len(drop_off_walk)):
    # at the last drop off before class
    if(i == len(drop_off_walk)-1):
        time += drop_off_walk[i]
        break
    # add the walk
    time += drop_off_walk[i]
    # if the current time is not a multiple of bus arrival, add the difference
    if (time - bus_arrival[i]) % bus_arrival[i] != 0:
        time += abs(time - bus_arrival[i])
    time += time_of_bus[i]
    i += 1

    
if(time > t): print("no")
else: print("yes")