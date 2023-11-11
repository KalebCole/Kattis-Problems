import java.util.HashMap;
import java.util.Scanner;

public class HayPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int words = sc.nextInt(), descriptions = sc.nextInt();
        int score = 0;
        HashMap<String, Integer> map = new HashMap<>();
        String job; int value;
        String line;
        String[] lineArr;
        // add to map
        for (int i = 0; i < words; i++) {
            job = sc.next(); value = sc.nextInt();
            map.put(job, value);
        }
        // get rid of blank
        sc.nextLine();
        // check the job descriptions
        for (int j = 0; j < descriptions; j++) {
                line = sc.nextLine();
                while(!line.equals(".")){
                    // iterate through the line to see if any keywords
                    lineArr = line.split(" ");
                    for (int k = 0; k < lineArr.length; k++) {
                        if(map.get(lineArr[k]) != null){
                            score += map.get(lineArr[k]);
                        }
                    }
                    line = sc.nextLine();
                }
                System.out.println(score);
                score = 0;

            }
    }
}
