import java.util.*;
public class CPRNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cpr = sc.nextLine();
		cpr = cpr.substring(0, cpr.indexOf("-")) + cpr.substring(cpr.indexOf("-")+1); //get rid of hyphen
		int num = 0;
		int sum = 0;
		for (int i = 0; i < cpr.length(); i++) {
			switch (i) {
			case 0:
				num = 4*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 1:
				num = 3*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 2:
				num = 2*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 3:
				num = 7*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 4:
				num = 6*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 5:
				num = 5*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 6:
				num = 4*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 7:
				num = 3*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 8:
				num = 2*Integer.parseInt(""+cpr.charAt(i));
				break;
			case 9:
				num = Integer.parseInt(""+cpr.charAt(i));
				break;
			}
			sum += num;
		}	
		if(sum%11 == 0) System.out.println(1);
		else System.out.println(0);
		sc.close();
		
	}

}
