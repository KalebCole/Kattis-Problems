import java.util.*;
import java.util.stream.*;

public class UnionFind<T> {
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