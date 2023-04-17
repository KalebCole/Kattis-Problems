import java.util.Scanner;
public class Autori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("-");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            s.append(line[i].charAt(0));
        }
        System.out.println(s);

        
    }

}