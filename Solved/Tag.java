import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Tag {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) throws Exception {
        int students = sc.getInt(), totalTags = sc.getInt();
        HashSet<String> hunters = new HashSet<>();
        SortedSet<String> cheaters = new TreeSet<>();
        hunters.add(sc.getWord()); // get the first hunter
        for (int i = 0; i < totalTags; i++) {
            String[] line = sc.getLine().split(" ");
            if (!hunters.contains(line[0])) {
                cheaters.add(line[0]);
            } else {
                hunters.remove(line[0]);
            }
            hunters.add(line[2]);
        }
        System.out.println(cheaters.size());
        Object[] temp = cheaters.toArray();
        for (int i = 0; i < cheaters.size(); i++) {
            System.out.print(temp[i]);
            if (i != cheaters.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
