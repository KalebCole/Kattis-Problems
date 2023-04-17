import java.util.*;
public class MagicTrick {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		HashSet<Character> s2 = new HashSet<>();
		for(int i = 0; i<s.length();i++) {
			s2.add(s.charAt(i));
		}
		if (s.length() == s2.size()) System.out.println("1");
		else System.out.println("0");
		
		
	}
}
