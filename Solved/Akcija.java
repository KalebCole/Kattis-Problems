import java.util.*;
public class Akcija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int index;
        //add all the prices into the array
        for(int i=0; i<n; i++){
            index = sc.nextInt();
            prices[i] = index;
        }

        //sort the array
        Arrays.sort(prices);

        int sum = 0;
        int counter = 0;
        for(int i = prices.length-1; i>=0; i--){
            if(counter < 2){
                sum+= prices[i];
                counter++;
            }
            else{
                counter = 0;
                continue;
            }
        }  
        System.out.println(sum);
}


}
