import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class IntegerLists {
	static Kattio io = new Kattio(System.in, System.out);

	public static void main(String[] args) throws NumberFormatException, Exception {
		int cases = Integer.parseInt(io.getLine()), size;
		byte[] functions;
		String temp;
		int[] nums;
		int leftDrops = 0, rightDrops = 0; // handle the 'R' and 'D'
		boolean reverseFlag = false;
		for (int i = 0; i < cases; i++) {
			leftDrops = 0;
			rightDrops = 0;
			reverseFlag = false;// reset
			functions = io.getLine().getBytes();
			size = Integer.parseInt(io.getLine());
			temp = io.getLine();
			nums = parseList(temp, size);
			for (int j = 0; j < functions.length; j++) {
				if (functions[j] == 68) { // check if it is 'D'
					if (!reverseFlag)
						leftDrops++;
					else
						rightDrops++;
				} else {
					reverseFlag = !reverseFlag;
				}
			}
			printList(nums, leftDrops, rightDrops, reverseFlag);
		}
		io.close();
	}

	public static void printList(int[] nums, int leftDrops, int rightDrops, boolean reverseFlag) {
		if (leftDrops + rightDrops > nums.length) { //deleting from empty list
			io.print("error");
		}
		else if(leftDrops+rightDrops == nums.length){ //empty list
			io.print("[]");
		}
		else if (!reverseFlag) { // starting from the front
			for (int i = leftDrops; i < nums.length - rightDrops; i++) {
				if (i == leftDrops)
					io.print("["+nums[i]+","); // first one
				else if (i == nums.length - rightDrops - 1)
					io.print(nums[i]+"]"); // last one
				else
					io.print(nums[i]+",");
			}
		} 
		else { // starting from the end
			for (int i = nums.length - 1 - rightDrops; i >= leftDrops; i--) {
				if (i == nums.length - 1 - rightDrops)
					io.print("["+nums[i]+","); // first one
				else if (i == leftDrops)
					io.print(nums[i]+"]"); // last one
				else
					io.print(nums[i]+",");
			}
		}
		io.print("\n");

	}

	public static int[] parseList(String line, int size) {
		int[] nums = new int[size];
		line = line.substring(1, line.length() - 1); // remove the brackets
		String[] lines = line.split(",");
		if (!lines[0].equals("")) {
			for (int i = 0; i < lines.length; i++) {
				nums[i] = Integer.parseInt(lines[i]);
			}
		}
		return nums;
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
