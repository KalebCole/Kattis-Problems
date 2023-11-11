import java.util.Scanner;
import java.util.Stack;

public class DelimiterSoup {
    public static void main(String[] args) {
        // if opening, push to stack
        // if closing, pop, check if they are equal
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(sc.nextLine());

        // put everything in a char array an iterate over it 
        char[] line = sc.nextLine().toCharArray();
        char temp;
        for (int i = 0; i < n; i++) {
            switch (line[i]){
                case '(':
                case '[':
                case '{':
                    stack.push(line[i]);
                    break;
                case ')':
                    if(stack.size() == 0){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    temp = stack.pop();
                    if (temp != '('){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    break;
                    case ']':
                    if(stack.size() == 0){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    temp = stack.pop();
                    if (temp != '['){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    break;
                    case '}':
                    if(stack.size() == 0){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    temp = stack.pop();
                    if (temp != '{'){
                        System.out.println(line[i] + " " + (i));
                        return;
                    }
                    break;                   
                
            }
        }
        // if(stack.size() > 0){
        //     System.out.println(stack.pop() + " " + ());
        // }
        System.out.println("ok so far");

    }
}
