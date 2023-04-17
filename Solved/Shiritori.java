import java.util.*;
class Shiritori{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String prev = sc.next();
        String curr = "";
        HashSet<String> words = new HashSet<>();
        words.add(prev);
        boolean isFair = true;
        for (int i = 1; i < n; i++) {
            curr = sc.next();
            if(prev.charAt(prev.length()-1) != curr.charAt(0) || words.contains(curr)){
                if (i % 2 != 1) System.out.println("Player 1 Lost");
                else System.out.println("Player 2 Lost");
                isFair = false;
                break;
            }
            words.add(curr);
            prev = curr;            
        }
        if (isFair) System.out.println("Fair Game");
        sc.close();
    }
}