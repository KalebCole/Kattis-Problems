import java.util.Scanner;

public class ScalingRecipe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(sc.nextInt()*y/x);
		}

	}

}
