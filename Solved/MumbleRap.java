import java.util.ArrayList;
import java.util.Scanner;

public class MumbleRap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println(mumbleRap(sc.nextLine()));
        sc.close();
    }

    public static int mumbleRap(String word) {
        int max = 0, start, end;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if(!Character.isDigit(word.charAt(i))){
                continue;
            }
            else{
                start = i;
                while(i < word.length() && Character.isDigit(word.charAt(i))){
                    i++;
                }
                end = i;
            }
            list.add(Integer.parseInt(word.substring(start, end)));
        }
        max = findMax(list);
        return max;
    }

    private static int findMax(ArrayList<Integer> list) {
        int max = 0;
        for (Integer integer : list) {
            if(integer > max) max = integer;
        }
        return max;
    }
}
