import java.util.Scanner;

public class ICPCTutorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int t = sc.nextInt();
		boolean works = true;
		switch (t) {
		case 1:
		int finalTime = 1;
			for (int i = n; i > 0; i--) {
				finalTime *= i;
				if (finalTime > m) {
					works = false;
					break;
				}
			}
			break;
		case 2:
			if(Math.log10(m)/Math.log10(2) < n) works = false;
			break;
		case 3:;
			if(Math.round(Math.pow(m,1.0/4)) < n) works = false;
			break;
		case 4:
		double temp = Math.round(Math.pow(m,1.0/3));
		if(Math.round(Math.pow(m,1.0/3)) < n) works = false;
			break;
		case 5:
		if(Math.round(Math.pow(m,1.0/2)) < n) works = false;
			break;
		case 6:
			if((n *(Math.log(n) / Math.log(2))) > m) works = false ;
			break;
		case 7:
			if(n>m) works = false;
			break;
		}
		if (works)
			System.out.println("AC");
		else
			System.out.println("TLE");
	}

}

