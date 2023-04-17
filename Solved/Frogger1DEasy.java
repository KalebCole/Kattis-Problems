import java.util.Scanner;

public class Frogger1DEasy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt()-1;
		int m = sc.nextInt();
		int[] board = new int[n];
		int[] repeat = new int[n];
		repeat[s] = 1;
		int hops = 0;
		for (int i = 0; i < n; i++) {
			board[i] = sc.nextInt();
		}
		// starting the logic
		boolean cont = true;
		if(board[s] == m) {
			System.out.printf("magic \n%d",hops);
			cont = false;
		}
		while (cont == true){
			hops++;
			s += board[s];
			if (s > n-1) {
				System.out.printf("right \n%d", hops);
				cont = false;
			} else if (s < 0) {
				System.out.printf("left \n%d", hops);
				cont = false;
			}
			
			else if (board[s] == m) {
				System.out.printf("magic \n%d", hops);
				cont = false;
			}
			else if (repeat[s] == 1) {
				System.out.printf("cycle \n%d", hops);
				cont = false;
			}
			else repeat[s] = 1;
		}

	}
}
