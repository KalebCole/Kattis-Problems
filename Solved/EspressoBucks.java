// Short circuit evaluation - with multiple conditions, stops checking after 1 is false
// can use to test edge cases

import java.util.Scanner;

public class EspressoBucks {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] grid = createMatrix(sc.nextInt(), sc.nextInt());

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '.' && canPlaceCoffeeShop(grid, i, j))
                    grid[i][j] = 'E';
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] createMatrix(int n, int m) {
        char[][] grid = new char[n][m];
        String row;
        // get rid of whitespace
        sc.nextLine();
        for (int i = 0; i < grid.length; i++) {
            row = sc.nextLine();
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        return grid;

    }

    public static boolean canPlaceCoffeeShop(char[][] grid, int row, int col) {

        if (row - 1 >= 0 && grid[row - 1][col] == 'E') {
            return false;
        }
        if (row + 1 < grid.length && grid[row + 1][col] == 'E') {
            return false;
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 'E') {
            return false;
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 'E') {
            return false;
        }
        return true;
    }

}
