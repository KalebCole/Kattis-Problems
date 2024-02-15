import java.util.*;
import java.util.stream.*;
import java.io.*;
/*
 * 
 * I am getting a TLE, I need to optimize my code
 * 
 * I am using a hashmap to store the groups, and the groups that have merged and then changing the references of the groups that have merged
 * 
 * It is slow because I am looping through the set of the group that has merged and then changing the references of the groups that have merged - O(n)
 * 
 * I need to use a union find data structure to optimize my code
 * 
 * 
 */
class Tildes {
	static Kattio io = new Kattio(System.in, System.out);

	public static void main(String[] args) {
		int n = io.getInt(), q = io.getInt();
		char query;
		// initialize an array
		int[] parentArr = new int[n];
		initialize(parentArr, n);
		for (int i = 0; i < q; i++) {
			query = io.getWord().charAt(0);
			if (query == 's') {
				// I need to return the size of the tree that I am generating
			} else if (query == 't') {
				// perform the union opertaion
			}
		}

	}

	public static void initialize(int Arr[], int N) {
		for (int i = 0; i < N; i++)
			Arr[i] = i;
	}

	// public static void main(String[] args) {
	// int n = io.getInt(), q = io.getInt();
	// char query;
	// HashMap<Integer, HashSet<Integer>> map = new HashMap<>();// key is group,
	// value is the set of groups that have
	// // merged
	// // we get the count based on the size of the set
	// for (int i = 0; i < q; i++) {
	// HashSet<Integer> temp = new HashSet<>();
	// query = io.getWord().charAt(0);
	// if (query == 't') {
	// int a = io.getInt(), b = io.getInt();
	// if (map.get(a) == null && map.get(b) == null) { // neither group is found
	// temp.add(a);
	// temp.add(b);
	// map.put(a, temp);
	// map.put(b, temp);
	// } else if (map.get(a) == null) { // a is not found
	// map.get(b).add(a); // a has merged
	// map.put(a, map.get(b)); // create a's group with b's set
	// } else if (map.get(b) == null) { // b is not found
	// map.get(a).add(b); // b has merged
	// map.put(b, map.get(a)); // create b's group with a's set
	// } else { // both are found
	// if (map.get(a) == map.get(b)) // they are the same reference!
	// continue;
	// // loop through the set, get all the elements, individually change the
	// // references
	// int[] nums = new int[map.get(b).size()];
	// int k = 0;
	// for (Integer num : map.get(b)) {
	// nums[k++] = num;
	// }
	// map.get(a).addAll(map.get(b));
	// for (int j = 0; j < nums.length; j++) {
	// map.put(nums[j], map.get(a));
	// }
	// }

	// } else { // query == 's'
	// // System.out.println(map);
	// int a = io.getInt();
	// if (map.get(a) != null)
	// System.out.println(map.get(a).size()); // size of the
	// // group
	// else
	// System.out.println(1);
	// }
	// }

	// }
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

class UnionFind<T> {
	private final Map<T, T> parentMap;
	private final Map<T, Integer> rankMap;
	private int count; // number of components

	// @param elements the initial elements to include (each element in a singleton
	// set).
	public UnionFind(Set<T> elements) {
		parentMap = new LinkedHashMap<>();
		rankMap = new HashMap<>();
		for (T element : elements) {
			parentMap.put(element, element);
			rankMap.put(element, 0);
		}
		count = elements.size();
	}

	public void addElement(T element) {
		if (parentMap.containsKey(element))
			throw new IllegalArgumentException(
					"element is already contained in UnionFind: " + element);
		parentMap.put(element, element);
		rankMap.put(element, 0);
		count++;
	}

	protected Map<T, T> getParentMap() {
		return parentMap;
	}

	protected Map<T, Integer> getRankMap() {
		return rankMap;
	}

	// returns the representative element in the set
	public T find(final T element) {
		if (!parentMap.containsKey(element)) {
			throw new IllegalArgumentException(
					"element is not contained in this UnionFind data structure: " + element);
		}

		T current = element;
		while (true) {
			T parent = parentMap.get(current);
			if (parent.equals(current)) {
				break;
			}
			current = parent;
		}
		final T root = current;

		current = element;
		while (!current.equals(root)) {
			T parent = parentMap.get(current);
			parentMap.put(current, root);
			current = parent;
		}

		return root;
	}

	/**
	 * Merges the sets which contain element1 and element2. No guarantees are given
	 * as to which
	 * element becomes the representative of the resulting (merged) set: this can be
	 * either
	 * find(element1) or find(element2).
	 */
	public void union(T element1, T element2) {
		if (!parentMap.containsKey(element1) || !parentMap.containsKey(element2)) {
			throw new IllegalArgumentException("elements must be contained in given set");
		}

		T parent1 = find(element1);
		T parent2 = find(element2);

		// check if the elements are already in the same set
		if (parent1.equals(parent2)) {
			return;
		}

		int rank1 = rankMap.get(parent1);
		int rank2 = rankMap.get(parent2);
		if (rank1 > rank2) {
			parentMap.put(parent2, parent1);
		} else if (rank1 < rank2) {
			parentMap.put(parent1, parent2);
		} else {
			parentMap.put(parent2, parent1);
			rankMap.put(parent1, rank1 + 1);
		}
		count--;
	}

	public boolean inSameSet(T element1, T element2) {
		return find(element1).equals(find(element2));
	}

	/**
	 * Returns the number of sets. Initially, all items are in their own set. The
	 * smallest number of
	 * sets equals one.
	 */
	public int numberOfSets() {
		assert count >= 1 && count <= parentMap.keySet().size();
		return count;
	}

	public int size() {
		return parentMap.size();
	}

	/**
	 * Resets the UnionFind data structure: each element is placed in its own
	 * singleton set.
	 */
	public void reset() {
		for (T element : parentMap.keySet()) {
			parentMap.put(element, element);
			rankMap.put(element, 0);
		}
		count = parentMap.size();
	}

	/**
	 * Returns a string representation of this data structure. Each component is
	 * represented as
	 * $\left{v_i:v_1,v_2,v_3,...v_n\right}$, where $v_i$ is the representative of
	 * the set.
	 * 
	 * @return string representation of this data structure
	 */
	public String toString() {
		Map<T, Set<T>> setRep = new LinkedHashMap<>();
		for (T t : parentMap.keySet()) {
			T representative = find(t);
			if (!setRep.containsKey(representative))
				setRep.put(representative, new LinkedHashSet<>());
			setRep.get(representative).add(t);
		}

		return setRep
				.keySet().stream()
				.map(
						key -> "{" + key + ":" + setRep.get(key).stream().map(Objects::toString).collect(
								Collectors.joining(",")) + "}")
				.collect(Collectors.joining(", ", "{", "}"));
	}
}