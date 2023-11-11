import java.util.Scanner;

public class UTF8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int n = Integer.parseInt(sc.nextLine());
        String utf;
        for (int i = 0; i < n; i++) {
            utf = sc.nextLine();
            // type 4
            if(utf.substring(0, 5).equals("11110")){
                if (i + 3 >= n){
                    System.out.println("invalid");
                    return;
                }
                for (int j = 0; j < 3; j++) {
                    utf = sc.nextLine();
                    if(i >= n){
                        System.out.println("invalid");
                        return;
                    }
                    if(!utf.substring(0, 2).equals("10")){
                        System.out.println("invalid");
                        return;
                    }
                    i++;
                }
                count4++;
            }
            // type 3
            else if(utf.substring(0, 4).equals("1110")){
                if (i + 2 >= n){
                    System.out.println("invalid");
                    return;
                }
                for (int j = 0; j < 2; j++) {
                    utf = sc.nextLine();
                    
                    if(!utf.substring(0, 2).equals("10") || i >= n){
                        System.out.println("invalid");
                        return;
                    }
                    i++;
                }
                count3++;
            }
            // type 2
            else if(utf.substring(0, 3).equals("110")){
                if (i + 1 >= n){
                    System.out.println("invalid");
                    return;
                }
                utf = sc.nextLine();
                    if(!utf.substring(0, 2).equals("10") || i >= n){
                        System.out.println("invalid");
                        return;
                    }
                    i++;
                count2++;
            }
            // type 1
            else if(utf.substring(0, 1).equals("0")){
                count1++;
            }
            else{
                System.out.println("Invalid");
                return;
            }
        }
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
        System.out.println(count4);
    }
}
