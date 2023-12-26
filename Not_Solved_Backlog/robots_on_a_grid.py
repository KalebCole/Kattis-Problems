'''
I most likely need to try an iterative approach with a queue

down_right = iterate from start to end, the end will have the total number
left_right_down_up = BFS --> queue
'''

def down_right(row, col):
    # base cases
    if (row == n-1 and col == n-1):
        return 1  # end
    if (row >= n or col >= n):
        return 0  # out of bounds
    if (grid[row][col] == "#"):
        return 0  # wall
    if (dr_grid[row][col] > 0):
        return dr_grid[row][col]  # already found

    # recursive call
    dr_grid[row][col] = (down_right(row+1, col) % (2 ** 31 - 1)) + (down_right(row, col+1) % (2 ** 31 - 1))
    return dr_grid[row][col]
def left_right_down_up_find_total_paths(row, col):
    # base cases
    if (row == n-1 and col == n-1):
        return 1  # end
    if (row >= n or col >= n or col < 0 or row < 0):
        return 0  # out of bounds
    if (grid[row][col] == "#"):
        return 0  # wall
    if (lrdu_already_taken[row][col]):
        return 0  # path has already been taken
    if (lrdu_grid[row][col] > 0):
        return lrdu_grid[row][col]  # already found

    # this path has now been taken
    lrdu_already_taken[row][col] = True

    # recursive calls
    lrdu_grid[row][col] = left_right_down_up_find_total_paths(row-1, col) + left_right_down_up_find_total_paths(
        row, col-1) + left_right_down_up_find_total_paths(row+1, col) + left_right_down_up_find_total_paths(row, col+1)
    return lrdu_grid[row][col]
def left_right_down_up_find_path(row, col):
    # base cases
    if (row == n-1 and col == n-1):
        return True  # end
    if (row >= n or col >= n or col < 0 or row < 0):
        return False  # out of bounds
    if (grid[row][col] == "#"):
        return False  # wall
    if (lrdu_already_taken[row][col]):
        return False  # path has already been taken
    
    lrdu_already_taken[row][col] = True
    
    # recursive calls
    return left_right_down_up_find_path(row-1, col) or left_right_down_up_find_path(row, col-1) or left_right_down_up_find_path(row+1, col) or left_right_down_up_find_path(row, col+1)
def get_input():
    global n, grid, dr_grid, lrdu_grid, lrdu_already_taken, lrdu_graph
    n = int(input())
    dr_grid = [[0] * n for _ in range(n)] #grid for only going 2 directions
    lrdu_grid = [[0] * n for _ in range(n)] #grid for going all 4 directions
    lrdu_already_taken = [[False] * n for _ in range(n)] #boolean array for if the path has been checked
    grid = []  # grid for robot playing field
    for _ in range(n):
        grid.append([*input()])  # unpack it to split it by characters
def main():
    get_input()
    dr_paths = down_right(0, 0)
    # we found the total # of paths by going down and right
    if dr_paths != 0:
        print(dr_paths % (2 ** 31 - 1))
    else:
        hasPath = left_right_down_up_find_path(0, 0)
        if hasPath:
            print("THE GAME IS A LIE")
        else:
            print("INCONCEIVABLE")
def make_test_case(i):
    import random
    # n = int(random.random() * 120 + 1)  # Grid size
    n = 5

    # Generate a random grid
    grid = [['.' if random.random() < 0.8 else '#' for _ in range(n)]
            for _ in range(n)]

    # Set start and end positions
    grid[0][0] = '.'
    grid[n-1][n-1] = '.'

    # Save the generated grid to a text file
    with open(f'./test_cases/test_case_{i}.txt', 'w') as file:
        file.write(f"{n}\n")
        for row in grid:
            file.write("".join(row) + "\n")
def check_test_case(i, end):
    # global n, grid, dr_grid, lrdu_grid, lrdu_already_taken
    while i < end:
        grid = []  # grid for robot playing field
        with open(f'./test_cases/test_case_{i}.txt', 'r') as file:
            lines = file.readlines()
            for index, line in enumerate(lines):
                if index == 0:
                    n = int(line)
                else:        
                    dr_grid = [[0] * n for _ in range(n)]
                    lrdu_grid = [[0] * n for _ in range(n)]
                    lrdu_already_taken = [[False] * n for _ in range(n)]
                    grid.append([*line])
            i+=1 
            main()

# Using right and down
def totalPaths(start):
    # I will use iteration and populate a grid with paths using top-down approach
    dr_grid[start.x][start.y] = 1
    # for i in range(len(dr_grid)):
        # for j in range()
    pass

# Using Left, Down, Right, Up
def findPath(start):
    pass

class Pair:
    def __init__(self, x, y) -> None:
        self.x = x
        self.y = y

if __name__ == "__main__":
    main()
        
        
