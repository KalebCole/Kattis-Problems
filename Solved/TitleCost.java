import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class TitleCost {

	public static void main(String[] args) throws Exception {
//		Kattio sc = new Kattio(System.in);
		String k ="";// sc.getLine();
		if (k.substring(0, k.indexOf(" ")).length() > Double.parseDouble(k.substring(k.indexOf(" ") + 1))) {
			System.out.printf(k.substring(k.indexOf(" ") + 1));
			return;
		}
		System.out.println(k.substring(0, k.indexOf(" ")).length());
	}
}

//class Kattio extends PrintWriter {
//		public Kattio(InputStream i) {
//			super(new BufferedOutputStream(System.out));
//			r = new BufferedReader(new InputStreamReader(i));
//		}
//
//		public Kattio(InputStream i, OutputStream o) {
//			super(new BufferedOutputStream(o));
//			r = new BufferedReader(new InputStreamReader(i));
//		}
//
//		public boolean hasMoreTokens() {
//			return peekToken() != null;
//		}
//
//		public int getInt() {
//			return Integer.parseInt(nextToken());
//		}
//
//		public double getDouble() {
//			return Double.parseDouble(nextToken());
//		}
//
//		public long getLong() {
//			return Long.parseLong(nextToken());
//		}
//
//		public String getWord() {
//			return nextToken();
//		}
//
//		public String getLine() throws Exception {
//			return r.readLine();
//		}
//
//		private BufferedReader r;
//		private String line;
//		private StringTokenizer st;
//		private String token;
//
//		private String peekToken() {
//			if (token == null)
//				try {
//					while (st == null || !st.hasMoreTokens()) {
//						line = r.readLine();
//						if (line == null)
//							return null;
//						st = new StringTokenizer(line);
//					}
//					token = st.nextToken();
//				} catch (IOException e) {
//				}
//			return token;
//		}
//
//		private String nextToken() {
//			String ans = peekToken();
//			token = null;
//			return ans;
//		}

//	}
