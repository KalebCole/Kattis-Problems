import java.util.*;
class Betting{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double line = sc.nextDouble();
        System.out.println(1/(line/100));   
        System.out.println(1/(1-(line/100)));   
    }
}