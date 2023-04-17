import java.util.Scanner;

public class FindingAnA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String k = sc.nextLine();
		for (int i = 0; i < k.length(); i++) {
			if(k.charAt(i) != 'a') continue;
			System.out.println(k.substring(i));
			break;
			
		}

	}

}
