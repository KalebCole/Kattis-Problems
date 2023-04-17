import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = 1;
		while (sc.hasNext()) {			
			int n = sc.nextInt();
			int min = sc.nextInt();
			int max = min;
			int range = 0;
			for (int i = 0; i < n - 1; i++) {
				range = sc.nextInt();
				if (min > range) min = range;
				else if (max < range) max = range;
			}
			range = max - min;
			System.out.printf("Case %d: %d %d %d\n",caseNum, min, max, range);
			caseNum++;
		}
	}

}
