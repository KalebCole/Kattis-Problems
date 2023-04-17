import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class PopularVote {
    static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) throws NumberFormatException, Exception {
        int t = Integer.parseInt(io.getLine()), n, totalVotes = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elections = 0; elections < t; elections++) {
            int currentElect = -1; totalVotes = 0;
            boolean tieFlag = false;
            n = Integer.parseInt(io.getLine());
            for (int nominee = 0; nominee < n; nominee++) {
                int vote = Integer.parseInt(io.getLine());
                map.put(nominee+1, vote);
                totalVotes +=vote;
            }
            for (Integer nominee : map.keySet()) {
                int nomineeVotes = map.get(nominee);
                if(currentElect == -1) currentElect = nominee;
                else if (nomineeVotes > map.get(currentElect)){
                    currentElect = nominee;
                    tieFlag = false;
                }
                else if(nomineeVotes == map.get(currentElect)){
                    tieFlag = true;
                }
            }
            if(tieFlag) System.out.println("no winner");
            else if(map.get(currentElect) > totalVotes/2) System.out.println("majority winner "+ currentElect);
            else System.out.println("minority winner "+ currentElect);
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
