import java.util.Scanner;
import java.util.TreeSet;

public class MissingGnomes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int m = Integer.parseInt(line.substring(line.indexOf(" ")+1));
        TreeSet<Integer> set = new TreeSet<>();
        int[] gnomes = new int[m];
        // add all the gnomes
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        int j = 0;
        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            if(set.contains(temp)) set.remove(temp);
            gnomes[j++] = temp;
        }

        gnomeOrder(set, gnomes);

    }

    public static void gnomeOrder(TreeSet<Integer> set, int[] gnomes) {
        int i = 0; //incrementer of the array
        while(i < gnomes.length && set.size() != 0){
            if(gnomes[i] > set.first()){
                System.out.println(set.pollFirst());
            }
            else{
                System.out.println(gnomes[i++]);
            }
        }

        while(i < gnomes.length){
            System.out.println(gnomes[i++]);
        }

        while(set.size() != 0){
            System.out.println(set.pollFirst());
        }
    }
}
