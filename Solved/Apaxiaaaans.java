import java.util.*;
public class Apaxiaaaans {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = s.charAt(0);
		StringBuilder sb = new StringBuilder(""+c);
		for(int i = 1; i<s.length(); i++) {
			if(c == s.charAt(i)) continue;
			c = s.charAt(i);
			sb.append(c);
		}
		System.out.println(sb);
		sc.close();
	}
}
