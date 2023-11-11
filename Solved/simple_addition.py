# take input as strings and split into list of nums
a = [int(x) for x in input()]
b = [int(x) for x in input()]

# read back to front in loop, add the nums from 2 lists
    #  sum is inserted into string
    #  carry is added to the next iteration
def add_big_nums(a,b):
    """ returns a string of the sum of the numbers

    Args:
        a (list): _description_
        b (list): _description_
    """
    sum_list = []
        
    carry = 0
    sum = 0
        # add the numbers and mod to get
    # start from the end because that's how we take in input
    b_index = len(b)-1
    a_index = len(a)-1
    
    while b_index >= 0 and a_index >= 0:
        # add carry to start because in first iteration, carry = 0
        sum = (a[a_index]+b[b_index] + carry) 
        carry = sum // 10
        sum_list.append(sum % 10)
        
        
        a_index -= 1
        b_index -= 1
    
    if b_index >= 0:
        for i in range(b_index,-1,-1):
            if carry > 0:
                sum = (b[i] + carry) 
                carry = sum // 10
                sum_list.append(sum % 10)   
            else:
                sum_list.append(b[i])
    
    if a_index >= 0:
        for i in range(a_index,-1,-1):
            if carry > 0:
                sum = (a[i] + carry) 
                carry = sum // 10
                sum_list.append(sum % 10)   
            else:
                sum_list.append(a[i])
    
    if carry > 0:
        sum_list.append(carry)
    sum = ""
    for num in sum_list:
        sum = str(num) + sum
    return sum


sum = add_big_nums(a,b)
print(sum)
