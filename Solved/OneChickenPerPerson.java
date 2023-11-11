import java.util.Scanner;

public class OneChickenPerPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int diff = m-n;
        if(diff == 1){
            System.out.printf("Dr. Chaz will have %d piece of chicken left over!", diff);
        }
        else if(diff > 0){
            System.out.printf("Dr. Chaz will have %d pieces of chicken left over!", diff);
        }        
        else if(diff == -1){
            System.out.println("Dr. Chaz  needs 1 more piece of chicken!");
        }
        else{
            System.out.printf("Dr. Chaz needs %d more pieces of chicken!", Math.abs(diff));
        }
    }
}
