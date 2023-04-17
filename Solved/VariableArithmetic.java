import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class VariableArithmetic {
// check for equal sign at the beginning
	public static void main(String[] args) throws Exception {
		Kattio io = new Kattio(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		while (true) {
			int sum = 0;
			StringBuilder output = new StringBuilder();
			String line = io.getLine();
			if (line.equals("0")) break; // case of 0
			if(line.contains("=")) { //var definition
				map.put(line.substring(sum, line.indexOf("=")-1), Integer.parseInt(line.substring(line.indexOf("=")+2)));
				continue;
			}
			String[] arr = line.split(" \\+ "); //arithmetic sums
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].matches(".*\\d.*")) {
					sum+=Integer.parseInt(arr[i]);
					continue;
				}
				if(map.get(arr[i]) != null) {
					sum+=map.get(arr[i]);
					continue;
				}
				output.append(" + " + arr[i]);				
			}
			if(sum == 0) {
				boolean notFound = false;
				for (String string : arr) {
					if(string.matches(".*\\d.*")) continue;
					if(map.get(string) == null) {
						notFound = true;
						break;
					}
				}
				if(notFound) {
					System.out.println(output.substring(3));
					continue;
				}
				System.out.println(0);
				continue;
			}
			System.out.println(sum + "" + output);
		}
		
	}

}

/**
 * Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) { int n = io.getInt(); double d = io.getDouble();
 * double ans = d*n;
 *
 * io.println("Answer: " + ans); }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 * Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an exception if
 * there is no more data in the input, so it is generally a good idea to use
 * hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */

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
