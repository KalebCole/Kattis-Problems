import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


class Tildes {
    static Kattio io = new Kattio(System.in, System.out);
    public static void main(String[] args) {
		int n = io.getInt(), q = io.getInt(); char query;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();//key is group, value is the set of groups that have merged
		//we get the count based on the size of the set
        for (int i = 0; i < q; i++) {
			HashSet<Integer> temp = new HashSet<>();
            query = io.getWord().charAt(0);
            if(query == 't'){
                int a = io.getInt(), b = io.getInt();
				if(map.get(a) == null && map.get(b) == null){ //neither group is found
					temp.add(a);
					temp.add(b);
					map.put(a, temp);
					map.put(b, temp);
				}
				else if(map.get(a) == null){ //a is not found
					map.get(b).add(a); //a has merged
					map.put(a, map.get(b)); //create a's group with b's set
				}
				else if(map.get(b) == null){ //b is not found
					map.get(a).add(b); //b has merged
					map.put(b, map.get(a)); //create b's group with a's set
				}
				else{ //both are found
					map.get(a).addAll(map.get(b));
					map.get(b).addAll(map.get(a));
				}

            }
            else{ // query == 's'
				int a = io.getInt(); int maxSize = 1;
				for (Integer person : map.keySet()) {
					if(map.get(person).contains(a)){
						if(map.get(person).size() > maxSize) maxSize = map.get(person).size(); //loop through all to make sure that updation anomolies don't affect anything
					}
				}
				System.out.println(maxSize); //size of the group
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

