import java.util.*;
public class BuildingPyramids {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(pyramidBuilder(sc.nextInt()));
	}
	public static int pyramidBuilder(int n) {
		int layer = 1;
		int height = 0;
		while (true) {
			n -= Math.pow(layer, 2);
			if(n < 0)
				return height; 
			layer += 2;
			height++;
			
			
		}
			
	}
}
