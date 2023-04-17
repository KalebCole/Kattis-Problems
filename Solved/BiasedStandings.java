import java.util.*;
public class BiasedStandings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int sum = 0;
		int temp = 0;
		for(int i = 0; i<t; i++) {
			sum = 0;
			int n = sc.nextInt();//# of people in list
			int[] arr2 = new int[n]; //original list
			int[] arr = new int[n]; // arr to sort list
			for(int j = 0; j<n; j++) {
				sc.next();//who cares about the team name
				int place = sc.nextInt(); //rank
				arr[j] = place;	
				arr2[j] = place;
			}
			mergeSort(arr); //sort array
			for(int k =0; k<n; k++) {
				sum+=Math.abs((k+1)-arr[k]); //sum of difference of placement
			}
			System.out.println(sum);
			}
			
			
		}
	public static void mergeSort(int[] arr) {
		if(arr.length <= 1) return;
		int[] left = new int[arr.length/2];
		int[] right = new int[arr.length - arr.length/2];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length/2) left[i] = arr[i];
			else {
				right[j] = arr[i];
				j++;
				}
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}
	
	public static void merge(int[] left, int[] right, int[] arr) {
		int i = 0; int j = 0; int k = 0;
		while(i< left.length && j<right.length) {
			if (left[i] > right[j]) {
				arr[k] = right[j];
				j++;
			}
			else {
				arr[k] = left[i];
				i++;
			}
			k++;
		}
		while (i<left.length) {
			arr[k] = left[i];
			i++; k++;
		}
		while (j<right.length) {
			arr[k] = right[j];
			j++; k++;
		}
		
	}
	}

