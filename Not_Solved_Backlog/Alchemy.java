import java.util.ArrayList;
import java.util.Scanner;

public class Alchemy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int mismatches = 0;
        ArrayList<String> misMatchesIndicies = new ArrayList<>(); //goes to the middle of the word
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) == s.charAt(s.length()-1-i))  continue;
            
        }
        int count = 0;

        


        /*
         * Find the locations of the places where there are consecutive mismatches
         * even consecutive: n/2
         * even consecutive: n/2+1
         * even (even consecutive): n/2
         * odd (even consecutive): n/2 + 1
         * odd 3-consecutive: 3*n/2+1
         * even 3-consecutive: 3*n/2
         * anything more: 2n
         */
    }
}  
