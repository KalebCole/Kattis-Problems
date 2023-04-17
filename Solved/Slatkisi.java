import java.util.Scanner;


public class Slatkisi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double c = sc.nextInt();
		double k = (int) Math.pow(10,sc.nextInt());
		double price = 0;
		price = Math.round(c/k)*k;
		System.out.println((int)price);
	}

}
