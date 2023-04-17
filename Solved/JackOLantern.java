import java.util.*;
public class JackOLantern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int volume = 1;
        String[] strArr = line.split(" ");
        for (int i =0; i<strArr.length; i++){
            volume *= Integer.parseInt(strArr[i]);
        }
        System.out.println(volume);
    }
}
