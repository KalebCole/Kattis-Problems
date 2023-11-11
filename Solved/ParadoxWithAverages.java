import java.util.Arrays;
import java.util.Scanner;

public class ParadoxWithAverages {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int test_cases = sc.nextInt();

        for (int i = 0; i < test_cases; i++) {

            // get input
            sc.nextLine(); // blank line
            int cs_students = sc.nextInt();
            int econ_students = sc.nextInt();

            int[] cs_iqs = new int[cs_students];
            double csAvg = 0, sumOfCSIqs = 0;
            for (int j = 0; j < cs_iqs.length; j++) {
                cs_iqs[j] = sc.nextInt();
                sumOfCSIqs += cs_iqs[j];
            }   
            csAvg = sumOfCSIqs/cs_students;
            
            int[] econ_iqs = new int[econ_students];
            double econAvg = 0, sumOfEconIqs = 0;
            for (int j = 0; j < econ_iqs.length; j++) {
                econ_iqs[j] = sc.nextInt();
                sumOfEconIqs += econ_iqs[j];
            }   
            econAvg = sumOfEconIqs/econ_students;
            
            int funnyStudents = 0;
            for (int j = 0; j < cs_iqs.length; j++) {
                if(cs_iqs[j] < csAvg && cs_iqs[j] > econAvg){
                    funnyStudents++;
                }
            }


            System.out.println(funnyStudents);   
        }

        sc.close();
    }
}
