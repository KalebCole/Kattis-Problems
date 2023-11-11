import java.util.Scanner;

public class Okviri {
    public static void main(String[] args) {
        // 0 = Wendy Frame, 1 = Peter Pan Frame
        int isPPF = -1, prev = -1, curr = -1; 
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        for (int i = 0; i < line.length(); i++) {
            // check if // 3
            curr = checkFrameType(line.charAt(i));
            // case: first letter
            if(prev == -1){
                // wendy
                if(curr == 0) isPPF = 0;
                // peter pan
                else isPPF = 1;
            }
            // middle and last

            // case: last letter
            if(curr == line.length()-1){

            }
        }   
    }
    private static int checkFrameType(char letter) {
        // 0 = Wendy Frame, 1 = Peter Pan Frame
        // do ASCII conversion and check if a 3rd letter
        if((letter - 65) % 3 == 0){
            return 0;
        }
        return 1;
    }

    private static void printAlternatingColumn(int isPPF) {
        // print PPF
        if(isPPF == 1){
            System.out.print("");
        }
        else{
            System.out.println("");
        }
    }

    public static void wendyFrame() {
        
    }

    public static void peterPanFrame() {
        
    }
}
