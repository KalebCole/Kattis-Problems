import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
class BootstrappingNumber {
		static final double epsilon = .000001; // Tolerance for how close the limit needs to be
    public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		double n = io.getDouble();
		System.out.println(squeeze(n, 1, n));
	}

	public static double squeeze(double n, double low, double high) {
		double mid = (low+high)/2;
		double num = Math.pow(mid,mid);
		//base case
		if(Math.abs(num - n) < epsilon){
			return mid;
		}
		//recursive call
		if(num > n){
			return squeeze(n, low, mid);
		}
		else{
			return squeeze(n, mid, high);
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
