import java.util.*;
public class OddEcho{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n+1];
        String word;
        for(int i=0; i<=n; i++){
            word = sc.nextLine();
            if(i%2!=0){
                words[i] = word;
            }
        }
        for (int j=0; j<words.length; j++){
            if(words[j]!=null)
                System.out.println(words[j]);
        }
    }
}