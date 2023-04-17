import java.util.Scanner;

public class Frogger1DHard {

	public static void main(String[] args) {
		/*
		 * Use A Sliding Window
		 *
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int[] board = new int[n];
		for (int i = 0; i < n; i++) board[i] = sc.nextInt();
		int numOfWinning = 0;
		boolean isWinner = true;
		while (true) {
			int[] repeat = new int[n];
			int magicIndex = 0;
			int magic = board[magicIndex];
			int curr = 0;
			
			if(isWinner) numOfWinning++;
			isWinner = false;
			
			
		}
	}

}
