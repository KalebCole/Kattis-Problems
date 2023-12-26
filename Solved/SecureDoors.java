import java.util.HashSet;
import java.util.Scanner;

public class SecureDoors {
    public static HashSet<String> inBuilding = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String inOrOut, name;
        for (int i = 0; i < n; i++) {
            inOrOut = sc.next();
            name = sc.next();
            boolean anomaly = isAnomoly(name, inOrOut);
            if(!anomaly && inOrOut.equals("entry")){
                inBuilding.add(name);
                System.out.printf("%s entered\n", name);
            }
            else if(anomaly && inOrOut.equals("entry")){
                System.out.printf("%s entered (ANOMALY)\n", name);
            }
            else if(!anomaly && inOrOut.equals("exit")){
                inBuilding.remove(name);
                System.out.printf("%s exited\n", name);
            }
            else if(anomaly && inOrOut.equals("exit")){
                System.out.printf("%s exited (ANOMALY)\n", name);
            }
        }
        sc.close();
    }
    public static boolean isAnomoly(String person, String inOrOut) {
        if(inOrOut.equals("entry")){
            if(inBuilding.contains(person)) return true;
            else return false;
        }
        else{
            if(!inBuilding.contains(person)) return true;
            else return false;
        }
    }
}
