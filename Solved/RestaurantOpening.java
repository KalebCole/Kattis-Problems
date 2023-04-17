import java.util.Scanner;

public class RestaurantOpening{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] city = new int[n][m];

        //make city grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        //compute minimum distance
        int minimumCost = Integer.MAX_VALUE, tempCost = 0;
        int x = 0,y = 0; //optimal location coords
        for (int i = 0; i < n*m; i++) { //check for each spot in the grid
            tempCost = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if(row == x && col == y) continue;
                    tempCost += (Math.abs(row-x) + Math.abs(col-y)) * city[row][col]; //distance times people  
                    if(tempCost > minimumCost) break; //early termination
                }
                if(tempCost >minimumCost) break; //early termination
            }
        if(tempCost < minimumCost) minimumCost = tempCost;
        //update optimal location coords
        y = (y+1) % m;
        if(y==0) x++;
        }        
        System.out.println(minimumCost);
    }
}