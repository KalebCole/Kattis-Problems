// import java.text.DecimalFormat;
// import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Stack;

public class Backspace {
    public static void main(String[] args) {
        // long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        
        char[] arr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int bracketCount = 0;
        // read from the right
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '<')
                bracketCount++;
            else if (arr[i] != '<' && bracketCount > 0)
                bracketCount--;
            else
                stack.push(arr[i]);
        }
        StringBuilder strB = new StringBuilder();
        while (!stack.isEmpty()) {
            strB.append(stack.pop());
        }
        System.out.println(strB.toString());
        // long end = System.currentTimeMillis();
        // NumberFormat formatter = new DecimalFormat("#0.00000");
        // System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }
}
