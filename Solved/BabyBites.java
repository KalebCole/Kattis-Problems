import java.util.Scanner;

public class BabyBites {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String temp;
        for (int i = 0; i < n; i++) {
            temp = sc.next();
            if (temp.equals("mumble")){
                continue;
            }
            if(Integer.parseInt(temp) != i+1){
                System.out.println("something is fishy");
                return;
            } 
        }
        System.out.println("makes sense");
    }
}
