def down_right(row, col):
    # base cases
    if(row == n-1 and col == n-1): return 1 #end
    if(row >= n or col >= n): return 0 #out of bounds
    if(grid[row][col] == "#"): return 0 #wall
    if(dr_grid[row][col] > 0): return dr_grid[row][col] #alreadcol found
    
    # recursive call
    dr_grid[row][col] = down_right(row+1,col) + down_right(row,col+1)
    return dr_grid[row][col]
def left_right_down_up(row,col):
    # base cases
    if(row == n-1 and col == n-1): return 1 #end
    if(row >= n or col >= n or col < 0 or row < 0): return 0 #out of bounds
    if(grid[row][col] == "#"): return 0 #wall
    if(lrdu_already_taken[row][col]): return 0 #path has alreadcol been taken
    if(lrdu_grid[row][col] > 0): return lrdu_grid[row][col] #alreadcol found
    
    # this path has now been taken
    lrdu_already_taken[row][col] = True
    
    # recursive calls
    lrdu_grid[row][col] = left_right_down_up(row-1,col) + left_right_down_up(row,col-1) + left_right_down_up(row+1,col) + left_right_down_up(row,col+1)
    return lrdu_grid[row][col]
def main():
    global n, grid, dr_grid, lrdu_grid, lrdu_already_taken
    n = int(input())
    dr_grid = [[0]*n for _ in range(n)]
    lrdu_grid = [[0] * n for _ in range(n)]
    lrdu_already_taken = [[False] * n for _ in range(n)]
    grid = [] # grid for robot playing field
    for _ in range(n):
        grid.append([*input()]) #unpack it to split it by characters

    dr_paths = down_right(0,0)
    # we found the total # of paths by going down and right
    if dr_paths != 0:
        print(dr_paths % (2 ** 31 -1))
    else:
        lrdu_paths = left_right_down_up(0,0)
        if lrdu_paths != 0:
            print("THE GAME IS A LIE")
        else:
            print("INCONCEIVABLE")
if __name__ == "__main__":
    main()
    

