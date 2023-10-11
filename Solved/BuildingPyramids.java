import java.util.Scanner;

public class BuildingPyramids {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(buildingPyramids(n, 0, 1));
    }
    public static int buildingPyramids(int n, int level, int blocks) {
        // base case
        if (n < (int)Math.pow(blocks, 2)) return level;

        return buildingPyramids(n-(int)Math.pow(blocks, 2), level+1, blocks+2);
    }
}
