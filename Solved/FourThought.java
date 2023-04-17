import java.util.*;
public class FourThought {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int i = 0; i<m; i++){
        int n = sc.nextInt();
        switch (n){
            case -60:
                System.out.println("4 - 4 * 4 * 4 = -60");
                break;
            case -16:
                System.out.println("4 - 4 - 4 * 4 = -16");
                break;
            case -15:
                System.out.println("4 / 4 - 4 * 4 = -15");
                break;
            case -8:
                System.out.println("4 - 4 * 4 + 4 = -8");
                break;
            case -7:
                System.out.println("4 / 4 - 4 - 4 = -7");
                break;
            case -4:
                System.out.println("4 / 4 / 4 - 4 = -4");
                break;
            case -1:
                System.out.println("4 - 4 / 4 - 4 = -1");
                break;
            case 0:
                System.out.println("4 - 4 - 4 + 4 = 0");
                break;
            case 1:
                System.out.println("4 + 4 / 4 - 4 = 1");
                break;
            case 2:
                System.out.println("4 / 4 + 4 / 4 = 2");
                break;
            case 4:
                System.out.println("4 - 4 / 4 / 4 = 4");
                break;
            case 7:
                System.out.println("4 - 4 / 4 + 4 = 7");
                break;
            case 8:
                System.out.println("4 + 4 + 4 - 4 = 8"); 
                break;
            case 9:
                System.out.println("4 + 4 + 4 / 4 = 9");
                break;
            case 15:
                System.out.println("4 * 4 - 4 / 4 = 15");
                break;
            case 16:
                System.out.println("4 + 4 + 4 + 4 = 16");
                break;
            case 17:
                System.out.println("4 * 4 + 4 / 4 = 17");
                break;
            case 24:
                System.out.println("4 * 4 + 4 + 4 = 24");
                break;
            case 32:
                System.out.println("4 * 4 + 4 * 4 = 32");
                break;
            case 60:
                System.out.println("4 * 4 * 4 - 4 = 60");
                break;
            case 68:
                System.out.println("4 * 4 * 4 + 4 = 68");
                break;
            case 256:
                System.out.println("4 * 4 * 4 * 4 = 256");
                break;
            default:
                System.out.println("no solution");
        }
        }
    }
}
