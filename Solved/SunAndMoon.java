import java.util.Scanner;

public class SunAndMoon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sD = sc.nextInt();
        int sY = sc.nextInt();
        int mD = sc.nextInt();
        int mY = sc.nextInt();
        int count = 0;
        while(mD != 0 || sD != 0){
            sD++;
            mD++;
            count++;
            if(mD == mY) mD=0;
            if(sD ==sY) sD=0;
        }
        System.out.println(count);
    }
}
