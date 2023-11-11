import java.util.HashMap;
import java.util.Scanner;

public class CookingWater {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> map = createMap(n);
        if(isSameTime(n, map)) System.out.println("gunilla has a point");
        else System.out.println("edward is right");
    }

    public static boolean isSameTime(int n, HashMap<Integer, Integer> map) {
        // loop throug map and find if there is a time where count (value) is same as n
        for (Integer count : map.values()) {
            if(count == n) return true;
        }
        return false;
    }
    
    public static HashMap<Integer, Integer> createMap(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int low, high;
        for (int i = 0; i < n; i++) {
            low = sc.nextInt(); high = sc.nextInt();
            for (int j = low; j <= high; j++) {
                if(map.containsKey(j)) map.put(j,map.get(j)+1);
                else map.put(j, 1);
            }
        }
        return map;
    }


}

