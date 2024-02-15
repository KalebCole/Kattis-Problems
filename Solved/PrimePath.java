import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class PrimePath {
    // calculate all the primes in a set
    // brute force all of the primes to each primes adjacency list: 1033 --> 2033
    // (not in set) --> 3033 --> ...
    // Use BFS on the list to find the shortest path
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> primes = getAllFourDigitPrimes();
        PrimeGraph graph = new PrimeGraph();
        for (Integer prime : primes) {
            graph.addPrime(prime);
        }
        addToAdjacencyList(primes, graph);
        for (int i = 0; i < n; i++) {
            int totalPaths = bfs(graph, sc.nextInt(), sc.nextInt());
            if (totalPaths == -1)
                System.out.println("Impossible");
            else
                System.out.println(totalPaths);

        }
    }

    private static int bfs(PrimeGraph graph, int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        int[] level = new int[10000]; // Counter for each level

        queue.add(start);
        visited[start] = true;
        level[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                return level[current]; // Return the counter for the target node
            }

            for (int adjacent : graph.adjacencyList.get(current)) {
                if (!visited[adjacent]) {
                    queue.add(adjacent);
                    visited[adjacent] = true;
                    level[adjacent] = level[current] + 1; // Increment the counter for the next level
                }
            }
        }

        return -1; // No path found
    }

    private static void addToAdjacencyList(HashSet<Integer> primes, PrimeGraph graph) {
        for (Integer primeInGraph : graph.adjacencyList.keySet()) {
            // brute force add all of them
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j <= 9; j++) {
                    int digit;
                    if (i == 1) {
                        digit = primeInGraph / 10;
                    } else if (i == 2) {
                        digit = primeInGraph / 100;
                    } else if (i == 3) {
                        if (j == 0)
                            continue; // no leading 0's
                        digit = primeInGraph / 1000;
                    } else {
                        digit = primeInGraph;
                    }
                    digit = digit % 10;
                    int subtracter = (digit * (int) Math.pow(10, i));
                    int digitToAdd = j * (int) Math.pow(10, i);
                    int testPrime = primeInGraph - subtracter + digitToAdd;

                    if (testPrime == primeInGraph)
                        continue; // do not add self
                    if (primes.contains(testPrime)) {
                        graph.addAdjacentPrime(primeInGraph, testPrime);
                    }
                }
            }
        }
    }

    public static HashSet<Integer> getAllFourDigitPrimes() {
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 1000; i <= 9999; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

class PrimeGraph {
    Map<Integer, ArrayList<Integer>> adjacencyList;

    public PrimeGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addPrime(int prime) {
        adjacencyList.put(prime, new ArrayList<>());
    }

    public void addAdjacentPrime(int prime, int adjacentPrime) {
        if (adjacencyList.get(prime) != null) {
            adjacencyList.get(prime).add(adjacentPrime);
        }
    }
}
