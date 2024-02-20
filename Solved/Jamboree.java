import java.util.Arrays;

public class Jamboree {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int n = sc.getInt();
        int m = sc.getInt();
        int max;
        if (m >= n) {
            max = findMax(n);
        } else {
            int[] scouts = new int[m];
            int[] items = new int[n];
            for (int i = 0; i < items.length; i++) {
                items[i] = sc.getInt();
            }
            Arrays.sort(items);
            updateScoutLoad(scouts, items);
            Arrays.sort(scouts);
            for (int i = 0; i < scouts.length; i++) {
                System.out.print(scouts[i] + " ");
            }
            max = scouts[scouts.length - 1];

        }
        System.out.println(max);
    }

    private static int findMax(int n) {
        int max = -1, temp = 0;
        for (int i = 0; i < n; i++) {
            temp = sc.getInt();
            if (temp > max)
                max = temp;
        }
        return max;
    }

    private static void updateScoutLoad(int[] scouts, int[] items) {
        // add 1 item
        int itemIndex = 0, i = 0;
        for (; i < scouts.length; i++) {
            itemIndex = items.length - i - 1;
            scouts[i] = items[itemIndex]; // add largest first
        }
        // add 2 items
        itemIndex--; // move one position down
        i = scouts.length - 1;
        while (itemIndex >= 0) {
            scouts[i] += items[itemIndex];
            itemIndex--;
            i--;
        }
    }

}
