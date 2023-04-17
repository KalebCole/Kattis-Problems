import java.util.*;
public class SMIL{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder line = new StringBuilder(sc.nextLine());
        HashSet<String> smiles = new HashSet<>(Arrays.asList(":)",";)",":-)",";-)"));
        for (int i = 0; i < line.length()-1; i++) {
            if(smiles.contains(line.substring(i,i+2)))
                System.out.println(i);
            if(i<line.length()-2){
                if(smiles.contains(line.substring(i,i+3)))
                System.out.println(i);
            }
        }

        sc.close();
    }
}