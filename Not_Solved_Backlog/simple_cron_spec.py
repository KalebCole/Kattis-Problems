'''
Input: single value, value range (inclusive on both sides), csv of single value or multiple values, and/ or asterisk (all values)

Note:
    - Hrs Mins Secs are delimited by a space
        - so when a space is reached, we need to go to next measure of time
    - Need to use a switch case to handle the different input tokens
    
Example:    
    * 30 20,25,30-33
        - * = multiply amount by 24 for 24 hours of the day
        - >= 30 = only can run once in the hour
            - so 60/mins | except for 30 = 1 time 
        - for single value, add 1 to count
        - for multiple values, add 1 for every comma (unless it is a range)
        - for range, add max-min

Steps:
    - Read as list and iterate 1 token at a time
        - Use a if-elif-else statement
    - 
'''

n = int(input())

for _ in range(n):
    line = [x for x in input().split(" ")]