import java.util.ArrayList;
import java.util.Scanner;

public class Simone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int minCount = Integer.MAX_VALUE;
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		for (int i = 1; i <= k; i++) {
			int currCount = 0;
			for(int j = 0; j < n; j++) {
				if(arr[j] == i) currCount++;
			}
			if(currCount>minCount) continue;
			if(currCount<minCount) {
				minCount = currCount;
				arrL.clear();
			}
			arrL.add(i);
			
			
		}
		
		System.out.println(arrL.size());
		for (Integer integer : arrL) {
			System.out.printf("%d ",integer);
		}
	}

}
