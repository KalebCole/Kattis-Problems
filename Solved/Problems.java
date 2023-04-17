import java.util.Scanner;
public class Problems {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    int n = sc.nextInt();
    if(n>100){
    int m = n/100*100;
    
    int c1 = m-1;
    int c2 = m+99;
    if((n-c1) < (c2-n)){
        System.out.println(c1);
    }
    else{
        System.out.println(c2);
    }
        }
    else{
        System.out.println(99);
    }
    }



    
    }

