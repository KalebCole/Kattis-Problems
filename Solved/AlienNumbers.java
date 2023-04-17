import java.util.HashMap;
import java.util.Scanner;

public class AlienNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++) {
		String aNum = sc.next();
		String sLang = sc.next();
		String tLang = sc.next();
		int dec = convertToDecimal(sLang, aNum);
		String newNum = convertToAlien(tLang, dec);
		System.out.printf("Case #%d: %s\n",i+1, newNum);
		}

	}

	public static int convertToDecimal(String sLang, String aNum) {
		HashMap<Character, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < sLang.length(); i++) {
			map.put(sLang.charAt(i), i);
		}
		for (int i = 0; i < aNum.length(); i++) {
			if (map.containsKey(aNum.charAt(i)))
				sum += (int) map.get(aNum.charAt(i)) * Math.pow(sLang.length(), aNum.length()-1-i);
		}
		return sum;
	}

	public static String convertToAlien(String tLang, int dec) {
		StringBuilder alien = new StringBuilder();
		while(dec > 0) {
			alien.insert(0,tLang.charAt(dec%tLang.length()));
			dec /= tLang.length();
		}		
		return alien.toString();

	}

}