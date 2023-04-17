import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class GoldbachsConjecture {
	static Kattio io = new Kattio(System.in, System.out);

	public static void main(String[] args) {

		int n = io.getInt(), x;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int count = 0;
			x = io.getInt();
			int[] primes = sieve(x);
			for (int j = 2, k = x-2; j <= x / 2 && k >=x/2; j ++, k--) {
				if (primes[j] == 0 && primes[k] == 0) {
					count++;
					list.add(j);
					list.add(k);
				}
			}
			System.out.printf("%d has %d representation(s)\n", x, count);
			for (int k = 1; k <= list.size(); k++) {
				if (k % 2 != 0)
					System.out.printf("%d+", list.get(k - 1));
				else
					System.out.printf("%d\n", list.get(k - 1));
			}
			System.out.println();
		}
	}

	public static int[] sieve(int num) {
		int[] primeArr = new int[num];
		int i = 2;
		while (i*i<=num){

			//if we already crossed out this number, continue
			if (primeArr[i] == 1){
				i+=1;
				continue;
			}
			int j = 2*i;
			while(j<num){
				primeArr[j] = 1;
				j+=i; //j is a multiple of i
			}
			i+=1;
		}
		return primeArr;
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
