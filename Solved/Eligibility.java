import java.util.*;
import java.io.*;

public class Eligibility {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int n = sc.getInt();
        for (int i = 0; i < n; i++) {
            String name = sc.getWord();
            int eligibility = isEligible(sc.getWord(), sc.getWord(), Integer.parseInt(sc.getWord()));
            if(eligibility == 1){
                System.out.println(name + " eligible");
            }
            else if(eligibility == -1){
                System.out.println(name + " ineligible");
            }
            else{
                System.out.println(name + " coach petitions");
            }

        }
    }

    private static int isEligible(String firstStudiedDate, String DOB, int courses) {
        if(Integer.parseInt(firstStudiedDate.substring(0, firstStudiedDate.indexOf("/"))) >= 2010 || Integer.parseInt(DOB.substring(0, DOB.indexOf("/"))) >= 1991){
            return 1;
        }
        else if(courses > 40){
            return -1;
        }
        return 0;
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
