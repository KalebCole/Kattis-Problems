import java.util.Arrays;

public class SubsetCalculator {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {1,2,3,4,5};
        int[] arr4 = {1,2,3,4,6};
        getSubsets(arr);
        System.out.println();
        getSubsets(arr2);
        System.out.println();
        getSubsets(arr3);
        System.out.println();
        getSubsets(arr4);
    }

    public static void getSubsets(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.print("]");
        if (arr.length == 1){
            return ;
        }
        else {
            getSubsets(Arrays.copyOfRange(arr, 0, arr.length-1));
            getSubsets(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }
}
