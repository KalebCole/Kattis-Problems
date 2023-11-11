import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemClassification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Category> categories = new ArrayList<>();
        String name;
        int words;
        for (int i = 0; i < n; i++) {
            HashSet<String> keywords = new HashSet<>();
            name = sc.next();
            words = sc.nextInt();
            for (int j = 0; j < words; j++) {
                keywords.add(sc.next());
            }
            categories.add(new Category(name, keywords));
        }
        sc.nextLine(); // get rid of new line character

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                for (Category category : categories) {
                    if (category.getKeywords().contains(line[i])) {
                        category.setTotalTimesFound(category.getTotalTimesFound() + 1);
                    }
                }
            }

        }

        Collections.sort(categories);
        int max = categories.get(0).getTotalTimesFound();
        for (Category category : categories) {
            if (category.getTotalTimesFound() >= max)
                System.out.println(category.getName());
        }
    }

}

class Category implements Comparable<Category> {
    private String name;
    private HashSet<String> keywords;
    private int totalTimesFound;

    public Category(String name, HashSet<String> keywords) {
        this.name = name;
        this.keywords = keywords;
        totalTimesFound = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(HashSet<String> keywords) {
        this.keywords = keywords;
    }

    public int getTotalTimesFound() {
        return totalTimesFound;
    }

    public void setTotalTimesFound(int totalTimesFound) {
        this.totalTimesFound = totalTimesFound;
    }

    @Override
    public int compareTo(Category o) {
        if (this.getTotalTimesFound() > o.getTotalTimesFound())
            return -1;
        else if (this.getTotalTimesFound() == o.getTotalTimesFound())
            return 0;
        else
            return 1;

    }

}
