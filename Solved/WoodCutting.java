import java.util.Arrays;
import java.util.Scanner;

public class WoodCutting {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            System.out.println(caseWaitTime(sc.nextInt())); 
        }
    }

    public static double caseWaitTime(int customers) {
        //this will be a method that runs on a singular case and i will run in a loop for multiple cases

        // i am going to loop through the customers
        //  denoted by '# of pieces x0 x1 ... xn'
        int currWait = 0; //this will be used when I calculate the avg wait
        double avgTime = 0;
        int[] customersArr = new int[customers]; // i am going to add all their wait times using currWait
        // get their times for their respective pieces
        for (int i = 0; i < customers; i++) {
            int pieces = sc.nextInt();
            for (int j = 0; j < pieces; j++) {
                customersArr[i] += sc.nextInt();
            }
        }

        // sort
        Arrays.sort(customersArr);

        // add up all their times using currWait
        for (int i = 0; i < customersArr.length; i++) {
            currWait += customersArr[i];
            avgTime += currWait; // adding times 0 + 0,1 + 0,1,2 + ...
        }

        avgTime /= customers;
        return avgTime;


    }
}
