import java.util.*;
public class AlphabetSpam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String spam = sc.nextLine().trim();
		double whitespace = 0;
		double lower = 0;
		double upper = 0;
		double symbol = 0;
		for(int i = 0; i < spam.length(); i++) {
			int c = spam.charAt(i);
			if(c == 95) whitespace++;
			else if(c>=65 && c<=90) upper++;
			else if(c>=97 && c<=122) lower++;
			else symbol++;
		}	
		System.out.println(whitespace/spam.length());
		System.out.println(lower/spam.length());
		System.out.println(upper/spam.length());
		System.out.println(symbol/spam.length());
	}

}
