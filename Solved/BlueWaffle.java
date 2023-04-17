import java.util.Scanner;

public class BlueWaffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int f = sc.nextInt();
        int rotations = f/r;
        int remainder = f%r;
        boolean isUp = false;
        if(rotations % 2 == 1){
            if(remainder > r/2) isUp = true;
        }
        else{
            if(remainder < r/2) isUp = true;
        }
        if(isUp) System.out.println("up");
        else System.out.println("down");
    }
}
