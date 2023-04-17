import java.util.*;
public class Cocktail {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int potions = sc.nextInt(); //num of potions
      int t = sc.nextInt(); //time to drink each potion
      int[] potionTimes = new int[potions];
      for(int i=0; i<potions; i++){
         potionTimes[i] = sc.nextInt();//each time duration of the potions
      } 
      Arrays.sort(potionTimes);
      int minimumTime = (potions-1)*t; //minimum time it requires for all potions to be in efect
      boolean isCorrect = true; //if it passes or not
      for(int i=potions-1; i>0; i--){
        if(potionTimes[i] <= minimumTime){
            isCorrect = false;
            break;
        }
        else{
            minimumTime -= t; 
        }   
        
        }
        if(isCorrect)
            System.out.println("YES");
        else
            System.out.println("NO");
      }
      
    }
