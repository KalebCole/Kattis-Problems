n = int(input())
for _ in range(n):
    s = input()
    spl = 0
    for i in range(1, len(s)):
        if int(s[i]) >= int(s[spl]):
            spl += 1
            continue
        spl = i
        break
    for i in range(spl+1, len(s)):
        if int(s[i]) > int(s[spl]):
            break
        spl += 1
    rise = s[:spl]
    fall = (s[spl]*len(s[spl:]))
    print(rise + fall)


    
    