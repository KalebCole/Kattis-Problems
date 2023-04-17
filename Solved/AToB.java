import java.util.Scanner;

public class AToB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 0;
		while(a!=b) {
			if (a < b) {
				count += b-a;
				break;
			}
			if(a%2 == 1) a++;
			else a/=2;
			count++;
		}
		System.out.println(count);

	}

}
