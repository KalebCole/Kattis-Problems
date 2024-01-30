import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Kattio io = new Kattio(System.in);
        while (io.hasMoreTokens()) {
            String line = io.getLine();
        }
        System.out.println(1);
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

    public String getLine() throws IOException {
        if (st != null && st.hasMoreTokens()) {
            // Decide how to handle the case where tokens are still available.
            // For example, clear them or throw an exception.
        }
        st = null; // Clear the tokenizer to force a fresh read on the next token-based operation.
        return r.readLine();
    }

    public void printLine(String line) {
        this.print(line);
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
