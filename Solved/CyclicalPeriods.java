import java.io.*;
import java.util.*;

public class CyclicalPeriods {
    public static void main(String[] args) {
        HashSet<Character> letters = new HashSet<>();
        Kattio sc = new Kattio(System.in);
        int n = sc.getInt();
        ArrayList<Letter> letterObjects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int location = sc.getInt();
            String line = sc.getWord();
            if (line.length() > 1) {
                // i can modularize this, but i don't want to rn
                for (int j = 0; j < line.length(); j++) {
                    // we haven't seen it yet & length > 1
                    if (!letters.contains(line.charAt(j))) {
                        letters.add(line.charAt(j));
                        letterObjects.add(new Letter(line.charAt(j), location));
                    }
                    // we have seen it & length > 1
                    for (Letter letter : letterObjects) {
                        if (letter.letter == line.charAt(j)) {
                            // if step > 0, we have seen it twice
                            if (letter.step > 0) {
                                break;
                            }
                            // if step == 0, we haven't seen it twice
                            letter.step = location - letter.start;
                            letter.locationInString = j;
                            break;
                        }
                    }
                }
            }
            // length == 1
            else {
                // we haven't seen it yet
                if (!letters.contains(line.charAt(0))) {
                    letters.add(line.charAt(0));
                    letterObjects.add(new Letter(line.charAt(0), location));
                }
                // we have seen it already
                else {
                    for (Letter letter : letterObjects) {
                        if (letter.letter == line.charAt(0)) {
                            // if step > 0, we have seen it twice
                            if (letter.step > 0) {
                                break;
                            }
                            // if step == 0, we haven't seen it twice
                            letter.step = location - letter.start;
                            break;
                        }
                    }
                }
            }
        }

        // sort the arrayList using a comparator
        Collections.sort(letterObjects, new Comparator<Letter>() {

            @Override
            public int compare(Letter o1, Letter o2) {
                // step is less
                if (o1.step > o2.step) {
                    return -1; // o1 < o2
                }
                // step is the same, then check start
                else if (o1.step == o2.step) {
                    // if start is the same, check locationInString
                    if (o1.start == o2.start) {
                        if (o1.locationInString < o2.locationInString) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } else if(o1.start < o2.start) {
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                // step is greater
                else{
                    return 1;
                }

            }
        });
        // found the longest cycle and print
        System.out.println(letterObjects.get(0).letter);

    }

    // 2 = we have seen it twice, skip
    // 1 = we have seen it once, but not a second time, and the length > 1 -->
    // update
    // step and locationInString
    // 0 = we have seen it one, but not a second time < 1, update the step

}

class Letter {
    int step;
    char letter;
    int start;
    int locationInString;

    public Letter(char letter, int start) {
        this.letter = letter;
        this.start = start;
        locationInString = Integer.MAX_VALUE;
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
