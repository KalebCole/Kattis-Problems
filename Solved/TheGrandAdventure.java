import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class TheGrandAdventure {
    static Kattio io = new Kattio(System.in, System.out);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, Exception {
        int n = Integer.parseInt(sc.nextLine());
        boolean isComplete = true;
        String s;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.clear();
            isComplete = true; //reset
            s = sc.nextLine().trim();
            for (int j = 0; j < s.length(); j++) {
                if(!isComplete) break;
                switch (s.charAt(j)) {
                    case '$':
                    case '|':
                    case '*':
                        stack.push(s.charAt(j));
                        break;
                    case 'b':
                        while (true) {
                            if (stack.isEmpty()) {
                                isComplete = false;
                                break;
                            }
                            char temp = stack.pop();
                            if (temp == '$')
                                break;
                        }
                        break;
                    case 't':
                        while (true) {
                            if (stack.isEmpty()) {
                                isComplete = false;
                                break;
                            }
                            char temp = stack.pop();
                            if (temp == '|')
                                break;
                        }
                        break;
                    case 'j':
                        while (true) {
                            if (stack.isEmpty()) {
                                isComplete = false;
                                break;
                            }
                            char temp = stack.pop();
                            if (temp == '*')
                                break;
                        }
                        break;
                }
            }
            if (!stack.isEmpty())
            isComplete = false;
            if (isComplete)
            System.out.println("YES");
            else
            System.out.println("NO");
        }

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

    public String getLine() throws Exception {
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
