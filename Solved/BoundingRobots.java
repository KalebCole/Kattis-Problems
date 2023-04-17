import java.util.Scanner;

public class BoundingRobots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int l = sc.nextInt();
			if (w == 0 && l == 0)
				break;
			int n = sc.nextInt();
			int robot_x = 0;
			int robot_y = 0;
			int actual_x = 0;
			int actual_y = 0;
			for (int i = 0; i < n; i++) {
				char dir = sc.next().charAt(0);
				int dis = sc.nextInt();
				switch (dir) {
				case 'u':
					robot_y += dis;
					actual_y += dis;
					break;
				case 'd':
					robot_y -= dis;
					actual_y -= dis;
					break;
				case 'l':
					robot_x -= dis;
					actual_x -= dis;
					break;
				case 'r':
					robot_x += dis;
					actual_x += dis;
					break;
				}
				if (actual_x > w-1)
					actual_x = w-1;
				else if (actual_x < 0)
					actual_x = 0;
				if (actual_y > l-1)
					actual_y = l-1;
				else if (actual_y < 0)
					actual_y = 0;				
			}
			System.out.printf("Robot thinks %d %d\n", robot_x, robot_y);
			System.out.printf("Actually at %d %d\n", actual_x, actual_y);
			System.out.println();
		}
		sc.close();
	}

}
