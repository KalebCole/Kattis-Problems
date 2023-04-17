import java.util.*;
public class FYI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = Integer.toString(sc.nextInt()).substring(0, 3);
        if(n.equals("555")){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }  
    }
    

}  
