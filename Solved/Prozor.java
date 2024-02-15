import java.util.Scanner;

public class Prozor {
    public static void main(String[] args) {
        // find the maximum number of flies by using method
        int max = 0;
        int[] startOfMostFlies = new int[2];
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt(), columns = sc.nextInt(), k = sc.nextInt();
        String[][] grid = new String[rows][columns];
        int[] start = new int[2];
        for (int i = 0; i < rows; i++) {
            String row = sc.next();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = String.valueOf(row.charAt(j));
            }
        }
        for (int i = 0; i < rows; i++) {
            start[0] = i;
            for (int j = 0; j < columns; j++) {
                start[1] = j;
                if (countNumberOfFlies(start, k, grid) > max) {
                    max = countNumberOfFlies(start, k, grid);
                    startOfMostFlies[0] = i;
                    startOfMostFlies[1] = j;
                }
            }
        }
        System.out.println(max);
        if (max == 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        } else {
            makeGrid(startOfMostFlies, k, grid);
        }
    }

    public static int countNumberOfFlies(int[] start, int sideLengthOfPaddle, String[][] grid) {
        int count = 0;
        if (cannotFitFlySwatter(start, sideLengthOfPaddle, grid)) {
            return 0;
        }
        for (int rows = start[0] + 1; rows < start[0] + sideLengthOfPaddle - 1; rows++) {
            if (rows > grid.length - 1) {
                count = 0;
                break;
            }
            // not starting on the sides of the paddle
            for (int columns = start[1] + 1; columns < start[1] + sideLengthOfPaddle - 1; columns++) {
                if (columns > grid[rows].length - 1) {
                    count = 0;
                    break;
                }
                if (grid[rows][columns].equals("*"))
                    count++;
            }
        }
        return count;
    }

    private static boolean cannotFitFlySwatter(int[] start, int sideLengthOfPaddle, String[][] grid) {
        if (start[0] + sideLengthOfPaddle - 1 > grid.length - 1
                || start[1] + sideLengthOfPaddle - 1 > grid[0].length - 1) {
            return true;
        }
        return false;
    }

    public static void makeGrid(int[] start, int sideLengthOfPaddle, String[][] grid) {
        String[][] output = new String[grid.length][grid[0].length];
        for (int rows = 0; rows < grid.length; rows++) {
            for (int columns = 0; columns < grid[rows].length; columns++) {
                // top and bottom row
                if (rows == start[0] || rows == start[0] + sideLengthOfPaddle - 1) {
                    if (columns == start[1] || columns == start[1] + sideLengthOfPaddle - 1)
                        output[rows][columns] = "+";
                    else if (columns > start[1] && columns < start[1] + sideLengthOfPaddle - 1) {
                        output[rows][columns] = "-";
                    } else {
                        output[rows][columns] = grid[rows][columns];
                    }
                } else if (rows > start[0] && rows < start[0] + sideLengthOfPaddle - 1) {
                    // left and right column
                    if (columns == start[1] || columns == start[1] + sideLengthOfPaddle - 1)
                        output[rows][columns] = "|";
                    else {
                        output[rows][columns] = grid[rows][columns];
                    }
                } else {
                    output[rows][columns] = grid[rows][columns];
                }

            }
        }
        printGrid(output);
    }

    private static void printGrid(String[][] output) {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }
}
