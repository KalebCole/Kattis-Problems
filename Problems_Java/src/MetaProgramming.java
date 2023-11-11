import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MetaProgramming {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // definition command
            if (sc.next().equals("define")) {
                int value = Integer.parseInt(sc.next());
                String key = sc.next();
                map.put(key, value);
            }
            // comparison command
            else {
                String str = sc.next();
                // first string not in map
                if (map.get(str) == null) {
                    System.out.println("undefined");
                    continue;
                }
                // in map
                char comparison = sc.next().charAt(0);
                String str2 = sc.next();
                // second string not in map
                if (map.get(str2) == null) {
                    System.out.println("undefined");
                    continue;
                }
                switch (comparison) {
                    case '>':
                        System.out.println(map.get(str) > map.get(str2));
                        break;
                    case '<':
                        System.out.println(map.get(str) < map.get(str2));
                        break;
                    case '=':
                        System.out.println(map.get(str) == map.get(str2));
                        break;

                }
            }

        }
        sc.close();
    }

}
