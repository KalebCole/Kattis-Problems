import java.util.Scanner;

public class HonorThyAxianParent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String child = sc.next();
        String parent = sc.next();

        if (ifItEndsWithAVowel(child, parent).equals("")) {
            if (child.substring(child.length() - 2, child.length()).equals("ex")) {
                System.out.println(child + parent);
            } else
                System.out.println(child + "ex" + parent);
        } else
            System.out.println(ifItEndsWithAVowel(child, parent));

    }

    public static String ifItEndsWithAVowel(String child, String parent) {
        switch (child.charAt(child.length() - 1)) {
            case 'e':
                return child + "x" + parent;
            case 'a':
            case 'i':
            case 'o':
            case 'u':
                return child.substring(0, child.length() - 1) + "ex" + parent;
            default:
                return "";
        }
    }
}
