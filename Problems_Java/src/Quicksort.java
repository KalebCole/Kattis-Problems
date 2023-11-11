public class Quicksort {
    public static void main(String[] args) {
        // test cases
        int[] arr = { 9, 8, 7, 6, 5, 4};
        int[] arr2 = { 1, 2, 3, 4, 7, 6, 5 };
        // worst case
        int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };
        quicksort(arr2, 0, arr2.length - 1);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low, j = high-1;
        // base case: i >= j
        while (i < j) {
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            while (arr[j] >= pivot && j > i) {
                j--;
            }
            swap(arr, i, j);
        }
        if(arr[i] > pivot){
            swap(arr, i, high);
        }
        // return the new index of pivot element
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;   
        }
        int j = partition(arr, low, high);
        quicksort(arr, low, j-1);
        quicksort(arr, j + 1, high);

    }
}
