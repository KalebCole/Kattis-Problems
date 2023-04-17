import java.util.Scanner;

public class SpeedLimit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			n = sc.nextInt();
			if (n==-1) break;
			int prevHours = 0;
			int currHours = 0;
			int dist = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				dist = sc.nextInt();
				currHours = sc.nextInt();
				sum += dist * (currHours-prevHours);
				prevHours = currHours;
			}
			System.out.println(sum+" miles");
		}
		
		

	}

}
