import java.util.*;
import java.io.*;
public class Beehives {
    static Kattio sc = new Kattio(System.in);
    public static void main(String[] args) {
        while(true){
            double d = sc.getDouble();
            int n = sc.getInt();
            if(n == 0) break; //terminating case
            Point[] points = makePointArr(n);
            int sourCounter = 0; 
            boolean[] isSour = findSourHoney(points, d);
            for (int i = 0; i < isSour.length; i++) {
                if(isSour[i]) sourCounter++;
            }
            System.out.printf("%d sour, %d sweet\n", sourCounter, n-sourCounter);

            

        }
    }

    private static boolean[] findSourHoney(Point[] points, double distance) {
        boolean[] isSour = new boolean[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if(IsTooCloseDistance(points[i], points[j], distance)){
                    isSour[i] = true;
                    isSour[j] = true;
                }
            }
        }
        return isSour;
    }

    private static boolean IsTooCloseDistance(Point point, Point point2, double distance) {
        // distance formula
        double x = Math.pow(point2.x - point.x, 2);
        double y = Math.pow(point2.y - point.y, 2);
        if(x+y < Math.pow(distance, 2)) return true;
        return false;

    }

    private static Point[] makePointArr(int n) {
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.getDouble(), sc.getDouble());
        }
        return points;
    }
}

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}