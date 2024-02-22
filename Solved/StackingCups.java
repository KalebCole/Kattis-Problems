import java.util.TreeMap;

public class StackingCups {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int n = sc.getInt();
        TreeMap<Integer, String> map = new TreeMap<>();
        String temp;
        for (int i = 0; i < n; i++) {
            temp = sc.getWord();
            boolean isNumber = false;
            try {
                Integer.parseInt(temp);
                isNumber = true;
            } catch (NumberFormatException e) {
            }
            if (isNumber) {
                map.put(Integer.parseInt(temp), sc.getWord());
            } else {
                map.put(sc.getInt()  * 2, temp);
            }
        }
        for (String color : map.values()) {
            System.out.println(color);
        }
    }
}
