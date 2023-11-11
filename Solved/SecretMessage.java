import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int l, m; String line, paddedString; char[][] matrix;
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            l = line.length();
            m = findSmallestSquare(l);
            paddedString = padString(line, (m-l));
            matrix = stringToMatrix(paddedString);
            readFromRotatedMatrix(matrix);
        }
    }
    public static int findSmallestSquare(int l) {
        int num =  (int)Math.ceil(Math.sqrt(l));
        return (int)Math.pow(num, 2);
    }
    /**
     * 
     * @param s - string of size L
     * @param num - L-M
     * @return string padded to size M
     */
    public static String padString(String s, int num) {
        StringBuilder strB = new StringBuilder(s);
        strB.append("*".repeat(num));
        return strB.toString();
    }
    public static char[][] stringToMatrix(String s) {
        int len = (int)Math.sqrt(s.length()); 
        char[][] matrix = new char[len][len];

        int i = 0; int row = 0;
        while(i < s.length()){
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = s.charAt(i);
                i++;
            }    
            row++;
        }
        return matrix;
    }
    public static void readFromRotatedMatrix(char[][] matrix) {
        StringBuilder strB = new StringBuilder();
        for (int col = 0; col < matrix.length; col++) {
            for (int row = matrix.length-1; row >= 0; row--) {
                char letter = matrix[row][col];
                if(letter != '*') strB.append(matrix[row][col]);
            }
        }
        System.out.println(strB.toString());
    }
}
