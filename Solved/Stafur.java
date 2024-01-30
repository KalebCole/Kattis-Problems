import java.util.Scanner;
public class Stafur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s = sc.nextLine().charAt(0);
        if(isVowel(s) == 0) System.out.println("Jebb");
        else if(isVowel(s) == 1) System.out.println("Neibb");
        else System.out.println("Kannski");
    }

    private static int isVowel(char s) {
        s = Character.toLowerCase(s);
        switch (s) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return 0;        
            case 'y':
                return 2;
            default:
                return 1;
        }    
    }
}