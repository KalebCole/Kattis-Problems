public class DontBeFake {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int[] secondsInDay = new int[86400];
        int n = sc.getInt();
        for (int i = 0; i < n; i++) {
            int m = sc.getInt();
            for (int j = 0; j < m; j++) {
                int left = sc.getInt();
                int right = sc.getInt();
                updateValueRangeInArray(secondsInDay, left, right);
            }
        }
        int max = findMaxNumber(secondsInDay);
        int totalSecondsOverlap = findOverlap(secondsInDay, max);
        System.out.println(max);
        System.out.println(totalSecondsOverlap);
    }

    private static int findOverlap(int[] secondsInDay, int max) {
        int intervalCounter = 0;
        for (int i = 0; i < secondsInDay.length; i++) {
            if (secondsInDay[i] == max) {
                while (secondsInDay[i] == max) {
                    intervalCounter++;
                    i++;
                    if (i >= secondsInDay.length)
                        break; // validation
                }
                if (i >= secondsInDay.length)
                    break; // validation
                continue;
            }
        }
        return intervalCounter;
    }

    private static int findMaxNumber(int[] secondsInDay) {
        int max = -1;
        for (int i = 0; i < secondsInDay.length; i++) {
            if (secondsInDay[i] > max)
                max = secondsInDay[i];
        }
        return max;
    }

    private static void updateValueRangeInArray(int[] secondsInDay, int left, int right) {
        for (int i = left; i <= right; i++) {
            secondsInDay[i] += 1;
        }
    }
}
