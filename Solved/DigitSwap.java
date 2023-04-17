import java.util.*;
public class DigitSwap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(s.charAt(0) == s.charAt(1)) System.out.println(s);
		else System.out.println(s.substring(1,2) + s.substring(0,1));
	}
}
