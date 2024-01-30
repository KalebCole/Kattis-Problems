import java.util.*;

public class BirthdayMemorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            people[i] = new Person(line[0], line[2], Integer.parseInt(line[1]));
        }
        var arr = findLikeablePeople(people);
        System.out.println(arr.length);
        for (String name : arr) {
            System.out.println(name);
        }
    }

    public static String[] findLikeablePeople(Person[] people) {

        // put all of the people into the treemap based on birthday, (name,rank)
        // if collisions, keep the people with the highest rank
        // print everyone in the treemap
        TreeMap<String, String[]> map = new TreeMap<>();
        String[] likeablePeople;
        for (Person person : people) {
            if (map.get(person.birthday) == null) {
                map.put(person.birthday, new String[] { person.name, "" + person.rank });
                continue;
            }
            findMoreLikeablePerson(person, map);
        }
        likeablePeople = new String[map.size()];
        int i = 0;
        for (String name : map.keySet()) {
            likeablePeople[i++] = map.get(name)[0];
        }
        Arrays.sort(likeablePeople);
        return likeablePeople;

    }

    private static void findMoreLikeablePerson(Person person, TreeMap<String, String[]> map) {
        if (Integer.parseInt(map.get(person.birthday)[1]) > person.rank) {
            return;
        } else {
            map.put(person.birthday, new String[] { person.name, "" + person.rank });
        }
    }
}

class Person implements Comparable<Person> {
    String name;
    String birthday;
    int rank;

    public Person(String name, String birthday, int rank) {
        this.name = name;
        this.birthday = birthday;
        this.rank = rank;
    }

    @Override
    public int compareTo(Person o) {
        return this.rank - o.rank;
    }

}
