import java.util.Scanner;

public class SomeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("Either");
			break;
		case 2:
		case 6:
		case 10:
			System.out.println("Odd");
			break;
		case 4:
		case 8:
			System.out.println("Even");
			break;
		
		}
		
	}
}
