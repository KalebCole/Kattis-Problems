t = int(input())


for i in range(t):
    input()
    nums = input().split()
    gnum = nums[0]
    mgnum = nums[1]
    zilla = input().split()
    zilla.sort()
    mzilla = input().split()
    mzilla.sort()
    g = 0 # increment for godzilla array
    m = 0 # increment for mechagodzilla array
    winner = ''
    while True:
        if int(zilla[g]) < int(mzilla[m]): g += 1
        else: m += 1
        if g >= len(zilla): 
            winner = 'MechaGodzilla'
            break
        if m >= len(mzilla):
            winner = 'Godzilla'
            break
    print(winner)
    