import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        // key: item, value: count
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String item;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                item = sc.next();
                if (map.containsKey(item))  map.put(item, map.get(item)+1);
                else map.put(item, 1);
            }
        }
        // check if they are in every list
        ArrayList<String> list = new ArrayList<>();
        for (String thing : map.keySet()) {
            if (map.get(thing) == n){
                list.add(thing);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (String string : list) {
            System.out.println(string);
        }
    }
}
