import java.util.Scanner;

public class Mult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            while(true){
                if(!sc.hasNextInt()) return;
                int next = sc.nextInt();
                if(next % num == 0){
                    System.out.println(next);
                    break;
                }
            }
        }
    }
}
