import java.util.HashMap;
import java.util.Scanner;

public class Recount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String line = "";
        while(sc.hasNext()){
            line = sc.nextLine();
            if(line.equals("***")) break;
            if(map.get(line) == null){
                map.put(line, 1);
            }
            else{
                map.put(line, map.get(line)+1);
            }
        }
        int max = -1; String person = ""; boolean isRunOff = false;
        for (String vote : map.keySet()) {
            if(map.get(vote) > max) {
                max = map.get(vote);
                person = vote;
                isRunOff = false;
            }
            else if(map.get(vote) == max){
                isRunOff = true;
            }
        }
        if(isRunOff) System.out.println("Runoff!");
        else System.out.println(person);
    }
}
