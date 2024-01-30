import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

import java.util.*;

public class Zoo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 1;
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            if(n == 0){
                return;
            }
            TreeMap<String, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] words = sc.nextLine().split(" ");
                String animal = words[words.length-1].toLowerCase();
                map.put(animal, map.getOrDefault(animal, 0) + 1);
            }
            printMap(map, count);
            count++;
        }
    }

    private static void printMap(TreeMap<String, Integer> map, int count) {
        System.out.println("List " + count + ":");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
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