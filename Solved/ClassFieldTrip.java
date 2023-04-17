import java.util.Scanner;

public class ClassFieldTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ann = sc.nextLine();
        String ben = sc.nextLine();
        char[] both = (ann+ben).toCharArray();
        mergeSort(both);
        System.out.println(both);
        
    }

    public static void mergeSort(char[] arr) {
        //base case
        if(arr.length == 1) return;
        //recursive call
        int leftLength = arr.length/2;
        int rightLength = arr.length-arr.length/2;  
        
        char[] left = new char[leftLength];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        char[] right = new char[rightLength];
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[leftLength+i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }

    public static void merge(char[] left, char[] right, char[] original) {
        int i = 0, j = 0, k = 0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                original[k] = left[i];
                i++;
            }
            else{
                original[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            original[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            original[k] = right[j];
            j++;
            k++;
        }
    }
}
