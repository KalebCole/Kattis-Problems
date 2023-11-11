import java.util.Scanner;

public class ElectricalOutlets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int sum = 0; 
            for (int j = 0; j < k; j++) {
                if(j == 0){
                    sum += sc.nextInt();
                    continue;
                }
                sum += sc.nextInt() - 1;
            }
        System.out.println(sum);
        }
    }
}
