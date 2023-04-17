import java.util.Scanner;

public class WhoGoesThere {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] teams = new int[m];
		int[] allowed = new int[m];
		int sumOfTeams = 0;
		int capacity = n;
		for (int i = 0; i < m; i++) {
			teams[i] = sc.nextInt();
			sumOfTeams += teams[i];
		}
		
		if(sumOfTeams <= n) {
			printArray(teams);
			sc.close();
			return;
		}
		
		//more teams than capacity		
		while(capacity>0) {
			int nOfT = findValidTeams(teams);
			int minNum = findMinNum(teams, capacity, nOfT); //the minimum number of all schools with teams > 1
			for (int j = 0; j < m; j++) {
				if(teams[j] == 0) continue;
				if(capacity <= 0) break; //if the remaining schools cannot add anymore teams - terminate
				teams[j] -= minNum;
				allowed[j] += minNum;
				capacity-=minNum;
			}
			
		}
		printArray(allowed);
		sc.close();

	}
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public static int findMinNum(int[] arr, int capacity, int nOfT) {
		int minNum = Integer.MAX_VALUE;	
		for (int i : arr) {
			if(i == 0) continue;
			if(i<minNum) minNum = i;
		}
		while(minNum*nOfT>capacity) minNum--; //if minNum cannot be subtracted from every team
		if(minNum == 0) minNum++;
		return minNum;
	}
	public static int findValidTeams(int[] arr) {
		int nOfT = arr.length;
		for (int i : arr) {
			if(i==0) nOfT--;
		}
		return nOfT;
	}
}
