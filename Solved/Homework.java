import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String problems = sc.nextLine();
		String[] prob = problems.split(";");
		int sum = 0;
		for (int i = 0; i < prob.length; i++) {
			if(prob[i].contains("-")) {
				sum += Integer.parseInt(prob[i].substring(prob[i].indexOf("-")+1)) - Integer.parseInt(prob[i].substring(0, prob[i].indexOf("-"))) + 1;
			}
			else sum+= 1;
		}
		System.out.println(sum);
	}

}
