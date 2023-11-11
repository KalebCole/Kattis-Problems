import java.util.Scanner;

public class Vacuumba {
    public static void main(String[] args) {
        // because we are oriented facing up, theta is 90 degrees
        // angle is temp angle of the current move
        double theta, distance, angle;
        int n, m;
        double x, y;
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            theta = Math.PI / 2;
            x = 0; y = 0;
            m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                // convert to radians
                angle = sc.nextDouble() * Math.PI / 180;
                theta += angle;
                distance = sc.nextDouble();
                x += distance * Math.cos(theta);
                y += distance * Math.sin(theta);
            }
            System.out.printf("%f %f\n", x, y);   
        }



    }
}
