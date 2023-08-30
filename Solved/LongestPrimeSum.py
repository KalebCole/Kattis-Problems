def longestPrime(num, max, list):
    # base case
    if (num > max):
        return
    if (num > 0 and max%num == 0): list.append(num) 
    
    #recursive call
    longestPrime(num*10+2, max, list)
    longestPrime(num*10+4, max, list)
    
    
n = int(input())
num = 0
list = []
longestPrime(num, n, list)

list.sort()

print(' \n'.join(str(element) for element in list))