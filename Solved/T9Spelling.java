import java.util.Scanner;

public class T9Spelling {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int n = Integer.parseInt(io.nextLine());

        int[] arr = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
        int y = 0; // storing previous

        for (int i = 1; i <= n; i++) {
            String temp = io.nextLine();
            String[] array = temp.split("");
            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < array.length; j++) {
                if (y == 32 && array[j].equals(" ")) {
                    System.out.print(" ");
                } else if ((!(array[j].equals(" "))) && y == arr[array[j].charAt(0) - 97]) {
                    System.out.print(" ");
                }
                System.out.print(buttonToPress(array[j]));
                if (array[j].equals(" "))
                    y = 32;
                else
                    y = arr[array[j].charAt(0) - 97];
            }
            System.out.println();
        }
        io.close();
    }

    public static String buttonToPress(String a) {
        switch (a) {
            case "a":
                return "2";
            case "b":
                return "22";
            case "c":
                return "222";
            case "d":
                return "3";
            case "e":
                return "33";
            case "f":
                return "333";
            case "g":
                return "4";
            case "h":
                return "44";
            case "i":
                return "444";
            case "j":
                return "5";
            case "k":
                return "55";
            case "l":
                return "555";
            case "m":
                return "6";
            case "n":
                return "66";
            case "o":
                return "666";
            case "p":
                return "7";
            case "q":
                return "77";
            case "r":
                return "777";
            case "s":
                return "7777";
            case "t":
                return "8";
            case "u":
                return "88";
            case "v":
                return "888";
            case "w":
                return "9";
            case "x":
                return "99";
            case "y":
                return "999";
            case "z":
                return "9999";
            case " ":
                return "0";
            default:
                return "";
        }

    }
}