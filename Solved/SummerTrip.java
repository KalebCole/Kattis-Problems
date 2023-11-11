// I can solve this faster if I find the index of the current character and add the length of the substring to the total

import java.util.HashSet;

import java.util.Scanner;

public class SummerTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] events = sc.nextLine().toCharArray();
        sc.close();

        System.out.println(countGoodItineraries(events));
    }

    public static int countGoodItineraries(char[] events) {
        int total = 0;
        var set = new HashSet<Character>();
        for (int i = 0; i < events.length; i++) {
            for (int j = i + 1; j < events.length; j++) {
                if (events[j] == events[i])
                    break;
                set.add(events[j]);
            }
            total += set.size();
            set.clear();
        }

        return total;
    }
}
