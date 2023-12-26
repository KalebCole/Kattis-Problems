import java.util.Scanner;

public class Medium_2048 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int dir = sc.nextInt();
		switch (dir) {
		case 0:
			for (int i = 0; i < 4; i++) {
				int temp = 0;
				int j = 3; // starting from the right
				while (matrix[i][j - 1] == 0 && j > 0) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[i][j - 1];
					matrix[i][j - 1] = temp;
					j--;
				}
				if (matrix[i][j - 1] == matrix[i][j]) {// merge
					matrix[i][j - 1] = matrix[i][j - 1] + matrix[i][j];
					matrix[i][j] = 0;
					i--; // in case a swap occurs in the right of the grid and the while loop ends early
					continue;
				}
				/*
				 * This does not handle cases where you can merge on the left side
				 */
			}
		}
		printMatrix(matrix);

	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			System.out.println();
		}
	}

}
