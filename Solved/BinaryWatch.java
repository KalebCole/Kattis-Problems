import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class BinaryWatch {

	public static void main(String[] args) throws Exception {
		Kattio sc = new Kattio(System.in);
		String time = sc.getLine().trim();
		char[][] watch = new char[4][4];
		for (int i = 0; i < time.length(); i++) {
			switch (time.charAt(i)) {
				case '0':
					for (int j = 0; j < watch.length; j++) {
						watch[j][i] = '.';
					}
					break;
				case '1':
					for (int j = 0; j < watch.length; j++) {
						if(j == 3) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '2':
					for (int j = 0; j < watch.length; j++) {
						if(j == 2) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '3':
					for (int j = 0; j < watch.length; j++) {
						if(j == 2 || j == 3) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '4':
					for (int j = 0; j < watch.length; j++) {
						if(j == 1) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '5':
					for (int j = 0; j < watch.length; j++) {
						if(j == 1 || j ==3) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '6':
					for (int j = 0; j < watch.length; j++) {
						if(j == 1 || j == 2) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '7':
					for (int j = 0; j < watch.length; j++) {
						if(j == 1 || j == 2 || j == 3) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '8':
					for (int j = 0; j < watch.length; j++) {
						if(j == 0) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				case '9':
					for (int j = 0; j < watch.length; j++) {
						if(j == 0 || j == 3) {
							watch[j][i] = '*';
							continue;
						}
						watch[j][i] = '.';
					}
					break;
				default:
					break;
			}	
		}
		for (int i = 0; i < watch.length; i++) {
			System.out.print(watch[i][0]+" ");
			System.out.print(watch[i][1]+" ");
			System.out.print("  ");
			System.out.print(watch[i][2]+" ");
			System.out.print(watch[i][3]);
			System.out.println();
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
