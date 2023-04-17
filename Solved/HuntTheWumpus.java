import java.util.*;
public class HuntTheWumpus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); ArrayList<String> list = new ArrayList<>(); int moves = 0; int dis = 0; String guess;
        for (int i = 0; i < 4; i++) {
            StringBuilder last2 = new StringBuilder();
            s = s + (s/13)+15;
            last2.append(s%10);
            last2.insert(0,(s/10)%10);
            if(list.contains(last2.toString())){
                i--;
                continue;
            }
            list.add(last2.toString());
        }
        while(sc.hasNext()){
            guess = sc.next();
            if(list.contains(guess)){
                System.out.println("You hit a wumpus!");
                list.remove(guess);
            }
            if(list.size() > 0){
                dis = findDistance(list, guess);
                System.out.println(dis);
            }
            moves++;
        }
        System.out.printf("Your score is %d moves.",moves);
    }

    private static int findDistance(ArrayList<String> list, String guess) {
        int minDistance = Integer.MAX_VALUE; int manhattan;
        int y1 = Integer.parseInt(guess) % 10;  int x1 = (Integer.parseInt(guess)/10)%10; int y2, x2;
        for (String location : list) { // O(4) - loop doesn't matter
            y2 = Integer.parseInt(location) % 10;
            x2 = (Integer.parseInt(location)/10) % 10;
            manhattan = (Math.abs(x2-x1) + Math.abs(y2-y1));
            if(minDistance > manhattan) minDistance = manhattan;
        }     
        return minDistance;
    }
}
