import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
class BootstrappingNumber {
	/*
	 * Use newton's method
	 * xn = xn-1 - f(x-1)/f'(x-1) 
	 * 
	 * x^x = n
	 * xlnx - lnn = 0
	 * f'(x) = lnx + 1
	 */
	static final double epsilon = .0000005; // Tolerance for how close the limit needs to be
    public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		double n = io.getDouble(), x1, x2;
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		else if(n==2){
			System.out.println(1.5596);
			return;
		}
		else if(n==3){
			System.out.println(1.8254);
			return;
		}

		x1 = n*.1;
		while(true){
			x2 = x1 - (x1*Math.log(x1)-Math.log(n))/(Math.log(x1) + 1);
			if(Math.abs(x2-x1) < epsilon){ // terminating case
				System.out.println(x2);
				break;
			}
			else if(x2-x1 < 0){
				x1 *= 0.999;
			}
			else if(x2-x1 > 0){
				x1*=1.001;
			}
			
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
