// My logic, pair the 2 largest ones and add them greater value of them
// If odd, add the one that costs the least

import java.util.Arrays;
import java.util.Scanner;

public class Pizzubestun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), price = 0;
        int[] pizzas = new int[n]; 
        for (int i = 0; i < n; i++) {
            // get rid of pizza name
            sc.next();
            pizzas[i] = sc.nextInt();
        }

        Arrays.sort(pizzas);

        for (int i = n; i > 0; i-=2) {
            // case of odd #
            if(i == 1){
                price += pizzas[0];
                break;
            } 
            price += pizzas[i-1];
        }
        System.out.println(price);   
    }


}
