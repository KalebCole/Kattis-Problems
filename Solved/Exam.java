import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.nextLine());
		String mine = sc.nextLine().trim();
		String friend = sc.nextLine().trim();
		
		int totalDif = friend.length()-k;
		int totalSame = k;
		int maxCorrect = 0;
		for (int i = 0; i < friend.length(); i++) {
			if(mine.charAt(i) == friend.charAt(i) && totalSame != 0) {
				totalSame--;
				maxCorrect++;
			}
			else if(mine.charAt(i) != friend.charAt(i) && totalDif != 0) {
				totalDif--;
				maxCorrect++;
			}
		}
		System.out.println(maxCorrect);
		
	}

}

