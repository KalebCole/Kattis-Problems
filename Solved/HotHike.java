import java.util.*;
public class HotHike {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(sc.next());
			arr[i] = num;
		}
		
		int maxTemp = 41;
		int index = 0;
		for (int i = 0; i < arr.length-2; i++) {
			if(arr[i] < maxTemp && arr[i+2] < maxTemp) {
				if(arr[i] > arr[i+2]) maxTemp = arr[i];
				else maxTemp = arr[i+2];
				index = i+1;
			}
			
		}
		System.out.printf("%d %d",index, maxTemp);
	}

}
