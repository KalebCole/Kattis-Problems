import java.util.Scanner;

public class CaloriesFromFat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalFatCals = 0, totalCals = 0, totalPercentage = 0, totalFatPerc = 0, percOfTotalIsFat = 0;
        int hyphenCounter = 0;
        String temp = "";
        while (true) {

            for (int i = 0; i < 5; i++) {
                temp = sc.next();
                if (temp.equals("-")) {
                    totalFatCals = calculateTotalFatCals(totalCals, totalFatCals, totalPercentage, totalFatPerc, percOfTotalIsFat);
                    hyphenCounter++;
                    if (hyphenCounter == 2)
                        break;
                    double test = Math.round((totalFatCals / totalCals) * 100);
                    System.out.printf("%d%%\n", (int) (Math.round((totalFatCals / totalCals) * 100)));
                    totalFatCals = 0;
                    totalCals = 0;
                    totalPercentage = 0;
                    percOfTotalIsFat = 0;
                    totalFatPerc = 0;
                    continue;
                }
                // working with fat
                if (i == 0) {
                    if (temp.contains("g")) {
                        totalFatCals += convertToCals(Integer.parseInt(temp.substring(0, temp.indexOf("g"))), i);
                        totalCals += totalFatCals;
                    } else if (temp.contains("C")) {
                        totalFatCals += Integer.parseInt(temp.substring(0, temp.indexOf("C")));
                        totalCals += totalFatCals;
                    }
                    // percentage
                    else {
                        totalFatPerc = Integer.parseInt(temp.substring(0, temp.indexOf("%")));
                        totalPercentage += totalFatPerc;
                    }
                } else {
                    if (temp.contains("g")) {
                        totalCals += convertToCals(Integer.parseInt(temp.substring(0, temp.indexOf("g"))), i);
                    } else if (temp.contains("C")) {
                        totalCals += Integer.parseInt(temp.substring(0, temp.indexOf("C")));
                    }
                    // percentage
                    else {
                        totalPercentage += Integer.parseInt(temp.substring(0, temp.indexOf("%")));
                    }
                }
            }
        }
    }

    private static double calculateTotalFatCals(double totalCals, double totalFatCals, double totalPercentage,
            double totalFatPerc, double percOfTotalIsFat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateTotalFatCals'");
    }

    public static int convertToCals(int num, int i) {
        switch (i) {
            case 0:
                return num * 9;
            case 1:
            case 2:
            case 3:
                return num * 4;
            case 4:
                return num * 7;
            default:
                return -1;
        }
    }
}
