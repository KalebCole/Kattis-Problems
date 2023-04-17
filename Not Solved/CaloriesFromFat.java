import java.util.Scanner;

public class CaloriesFromFat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalFatCals = 0,totalCals = 0, percRemain = 100, currFatCals = 0, currCals = 0, fatPerc = 0;
        int hyphenCounter = 0; String temp = "";
        while(true){
            percRemain = 100; currFatCals = 0; currCals = 0;
            temp = sc.next();
            if(temp.equals("-")){
                hyphenCounter++;
                if(hyphenCounter==2) return;
                double test = Math.round((totalFatCals/totalCals)*100);
                System.out.printf("%d%%\n",(int)(Math.round((totalFatCals/totalCals)*100)));
                totalFatCals = 0;totalCals = 0; fatPerc = 0;
                continue;
            }
            if(temp.contains("g")) currFatCals += convertToCals(Integer.parseInt(temp.substring(0, temp.indexOf("g"))), 0);
            else if(temp.contains("C")) currFatCals += Integer.parseInt(temp.substring(0, temp.indexOf("C")));
            else {
                percRemain -= Integer.parseInt(temp.substring(0, temp.indexOf("%")));
                fatPerc = 100 - percRemain; //get the fat percentage
            }
            for (int i = 1; i < 5; i++) {
                temp = sc.next();
                if(temp.contains("g")) currCals += convertToCals(Integer.parseInt(temp.substring(0, temp.indexOf("g"))), i);
                else if(temp.contains("C")) currCals += Integer.parseInt(temp.substring(0, temp.indexOf("C")));
                else percRemain -= Integer.parseInt(temp.substring(0, temp.indexOf("%")));
            }
            if(fatPerc == 0){ //fat is not given as a percentage
                currCals += currFatCals;
                currCals /= (percRemain/100);
            }
            else{
                currCals = currCals/(percRemain/100);
                currFatCals = currCals*(fatPerc/100);
            }
            totalCals += currCals;
            totalFatCals += currFatCals;
            hyphenCounter = 0;     
            }
        }
    public static int convertToCals(int num, int i) {
        switch(i){
            case 0:
                return num*9;
            case 1:
            case 2:
            case 3:
                return num*4;
            case 4:
                return num*7;
            default:
                return -1;
        }
    }
}
