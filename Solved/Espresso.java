import java.util.Scanner;

public class Espresso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int tank = s;
		int size = 0;
		int count = 0;
		String line;
		for (int i = 0; i < n; i++) {
			line = sc.next();
			size = Integer.parseInt(""+line.charAt(0));
			if(line.length()>1) size++;
			if (size > tank) {
				count++;
				tank = s;
			}
			tank -= size;		
		}
		System.out.println(count);
	}

}
