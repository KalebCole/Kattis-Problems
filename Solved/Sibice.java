import java.util.*;
public class Sibice{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] lineArr = line.split(" ");
        int[] intArr = new int[lineArr.length];
        for (int i = 0; i<lineArr.length; i++){
            intArr[i] = Integer.parseInt(lineArr[i]);
        }
        int n = intArr[0];
        int w = intArr[1];
        int h = intArr[2];
        
        double underSqrt = (w*w) + (h*h);

        double hypotenuse = Math.sqrt(underSqrt);
        
        int match = 0;
        for(int i = 0; i<n; i++){
            match = sc.nextInt();
        if((double)match>hypotenuse){
            System.out.println("NE");
        }
        else{
            System.out.println("DA");
        }
        }
    }
}