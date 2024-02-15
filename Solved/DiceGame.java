import java.util.Scanner;

public class DiceGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double expectationOfGunnar = getExpectationFromDice();
        double expectationOfEmma = getExpectationFromDice();

        if (expectationOfGunnar > expectationOfEmma) {
            System.out.println("Gunnar");
        } else if (expectationOfGunnar < expectationOfEmma) {
            System.out.println("Emma");
        } else {
            System.out.println("Tie");
        }

    }

    private static double getExpectationFromDice() {
        // expectation of 1st dice
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        double expectationOfDieOne = ((double) (side2 + side1) / 2); // this is the average value from the sides divided by
        // the
        // probability of landing on it (num of sides)

        // expectation of 2nd dice
        int side3 = sc.nextInt();
        int side4 = sc.nextInt();
        double expectationOfDieTwo = ((double) (side4 + side3) / 2) ; // this is the average value from the
                                                                                  // sides divided by the

        return expectationOfDieOne + expectationOfDieTwo;

    }

}
