import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                int loc = vowelLocation(line[i]);
                if(loc == 0){
                    line[i] += "yay";
                }
                else{
                    String prefix = line[i].substring(0, loc);
                    line[i] = line[i].substring(loc) + prefix + "ay"; 
                }
            }
            for (String string : line) {
                System.out.printf("%s ",string);
            }
        }
        sc.close();
    }

    private static int vowelLocation(String string) {
        //returns the location of the first vowel
        for (int i = 0; i < string.length(); i++) {
            if(isVowel(string.charAt(i))) return i;
        }
        return -1;
    }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }
}
