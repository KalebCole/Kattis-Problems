import java.util.Scanner;

public class EulersNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getEuler(n));

	}
	public static double getEuler(int n) {
		double bd2 = 0;
		for(int i = n; i>=0; i--) {
		double bd = (1/getFactorial(i)); 
		bd2 += bd;
		}
		return bd2;
		
	}
	public static double getFactorial(int n) {
		if(n == 0) return 1;
		return (double)(n * getFactorial(n-1));
	}

}
