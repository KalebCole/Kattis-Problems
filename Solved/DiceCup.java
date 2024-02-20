import java.util.Scanner;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

public class DiceCup {
    // 2 for loops where I will add to a treeset
    // Key: sum , Value: count
    // they are ordered by the count
    //
    // O(m*n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mostLikelyOutcomes = findMostLikelyOutcomes(sc.nextInt(), sc.nextInt());
        for (int i = 0; i < mostLikelyOutcomes.length; i++) {
            if (mostLikelyOutcomes[i] == 0)
                break;
            System.out.println(mostLikelyOutcomes[i]);
        }
    }

    private static int[] findMostLikelyOutcomes(int die1, int die2) {
        TreeMap<Integer, Integer> map = calculateSampleSpace(die1, die2);

        // Create a custom Comparator to compare the values of the entries in the TreeMap
        Comparator<Integer> valueComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer key1, Integer key2) {
                int value1 = map.get(key1);
                int value2 = map.get(key2);
                if (value1 == value2) {
                    return Integer.compare(key1, key2); // Compare keys if values are equal
                }
                return Integer.compare(value2, value1);
            }
        };

        // Create a new TreeMap with the custom Comparator
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(valueComparator);
        sortedMap.putAll(map);

        int max = -1;
        int[] mostLikelyOutcomes = new int[die1 + die2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= max){
                max = value;
                mostLikelyOutcomes[i++] = key;

            }
        }
        return mostLikelyOutcomes;
    }

    private static TreeMap<Integer, Integer> calculateSampleSpace(int die1, int die2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= die1; i++) {
            for (int j = 1; j <= die2; j++) {
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                } else {
                    map.put(i + j, 1);
                }
            }
        }
        return map;
    }
}
