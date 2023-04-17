import java.util.Scanner;

public class Aaah {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String k = sc.nextLine();
		String l = sc.nextLine();
		if(k.length()<l.length()) System.out.println("no");
		else System.out.println("go");
	}

}
