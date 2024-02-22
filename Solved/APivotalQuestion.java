import java.util.ArrayList;

public class APivotalQuestion {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int n = sc.getInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.getInt();
        }
        int[] greatestLeftArr = calculateGreatestLeftArr(arr);
        int[] leastRightArr = calculateLeastRightArr(arr);
        ArrayList<Integer> pivotElements = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i] >= greatestLeftArr[i] && arr[i] <= leastRightArr[i]) {
        // pivotElements.add(arr[i]);
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            boolean isPivot = true;
            if (i > 0 && arr[i] < greatestLeftArr[i - 1])
                isPivot = false;
            if (i < arr.length - 1 && arr[i] >= leastRightArr[i + 1])
                isPivot = false;

            if (isPivot)
                pivotElements.add(arr[i]);
        }
        if (pivotElements.size() == 0) {
            System.out.print(0);
        } else {
            System.out.print(pivotElements.size() + " ");
        }
        for (int i = 0; i < pivotElements.size(); i++) {
            // if we reach the end or 100th element
            if (i == pivotElements.size() - 1 || i == 99) {
                System.out.print(pivotElements.get(i));
                break;
            } else {
                System.out.print(pivotElements.get(i) + " ");
            }

        }
    }

    // need to update this based on arrays of 1, 2
    private static int[] calculateLeastRightArr(int[] arr) {
        int[] leastRightArr = new int[arr.length];
        leastRightArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < leastRightArr[i + 1])
                leastRightArr[i] = arr[i];
            else
                leastRightArr[i] = leastRightArr[i + 1];
        }
        return leastRightArr;

    }

    // need to update this based on arrays of 1, 2
    private static int[] calculateGreatestLeftArr(int[] arr) {
        int[] greatestLeftArr = new int[arr.length];
        greatestLeftArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > greatestLeftArr[i - 1])
                greatestLeftArr[i] = arr[i];
            else
                greatestLeftArr[i] = greatestLeftArr[i - 1];
        }
        return greatestLeftArr;
    }
}
