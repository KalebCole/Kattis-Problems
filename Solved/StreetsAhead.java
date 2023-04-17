import java.util.HashMap;
import java.util.Scanner;

public class StreetsAhead {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cross = sc.nextInt();
        int driver = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cross; i++) {
            map.put(sc.next(), i);
        }
        for (int i = 0; i < driver; i++) {
            String first = sc.next();
            String second = sc.next();
            if(map.get(second)> map.get(first)){
                System.out.println(map.get(second) - map.get(first)-1);
                continue;
            }
            System.out.println(map.get(first) - map.get(second) -1);
        }
        sc.close();
    }
}
