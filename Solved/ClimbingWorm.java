import java.util.Scanner;

public class ClimbingWorm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), h = sc.nextInt();
        System.out.println(climbingWorm(a, b, h));
    }
    public static int climbingWorm(int climb, int rest, int height) {
        int current = 0;
        int count = 0;
        while(current != height){
            count++;
            current += climb;
            if(current >= height) break;
            current -= rest;
        }
        return count;
    }
}
