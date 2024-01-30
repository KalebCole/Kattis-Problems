import sys


def findFruits(capacity, fruits):
    arr = []
    for i in range(len(fruits)):
        curr_capacity = 0
        if fruits[i] > capacity:
            arr.append(0)
        else:
            if i == len(fruits) - 1:
                arr.append(1)
                break
            curr_capacity += fruits[i]
            start = end = i
            for j in range(i+1, len(fruits)):
                if curr_capacity + fruits[j] <= capacity:
                    curr_capacity += fruits[j]
                    if j == len(fruits) - 1:
                        end = j+1
                        arr.append(end-start)
                        break
                    continue
                else:
                    end = j
                    arr.append(end-start)
                    break
    return arr


# _, c = [int(x) for x in sys.stdin.readline().split()]
# fruits = [int(x) for x in sys.stdin.readline().split()]
countArr = findFruits(4, [1, 4, 1, 1, 1, 4])
countArr.sort(reverse=True)
print(countArr[0])
