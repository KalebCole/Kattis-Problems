import java.util.*;
public class TurnItUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int volume = 7;
		for(int i = 0; i<n;i++) {
			String s = sc.nextLine().trim();
			if(s.equals("Skru op!") && volume < 10) {
				volume++;
			}
			if(s.equals("Skru ned!") && volume > 0) {
				volume--;
			}
		}
		System.out.println(volume);
	}

}
