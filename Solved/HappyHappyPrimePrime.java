import java.util.HashSet;
import java.util.Scanner;

class HappyHappyPrimePrime{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //must check to see if the word is prime
        int n = sc.nextInt();
        int m, temp;
       
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int sumOfDigits = -1;
            sc.nextInt(); //we do not care about K
            m = sc.nextInt();
            temp = m;  
            if(!isPrime(m)){//if not prime 
                System.out.printf("%d %d NO\n",i+1,m); 
                continue;
            }
            if(m == 1) {//1 is not prime
                System.out.printf("%d %d NO\n",i+1,m); 
                continue; 
            }
            while (true){
                sumOfDigits = sumOfDigitsSquared(temp);
                temp = sumOfDigits;
                if(temp == 1){ //happy prime
                    System.out.printf("%d %d YES\n",i+1,m); //if the # is already found, then infinite loop
                    break;
                }
                if(set.contains(temp)){
                    System.out.printf("%d %d NO\n",i+1,m); //if the # is already found, then infinite loop
                    break;
                }
                
                set.add(sumOfDigits); set.add(flipNumber(sumOfDigits));
            }
            
        }
        
        
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public static int sumOfDigitsSquared(int num) {
        int digit = 0;
        int sum = 0;
        while(num!=0){
            digit = num%10;
            num /= 10;
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
    public static int flipNumber(int num) {
        StringBuilder numStr = new StringBuilder(""+num).reverse();
        return Integer.parseInt(numStr.toString());
    }
}