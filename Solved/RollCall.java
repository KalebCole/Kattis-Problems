// Sort based on last name, but print is based on matching first names

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class RollCall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var people = new ArrayList<Person>();

                
        while (sc.hasNextLine()) {
            String[] names = sc.nextLine().split(" ");
            people.add(new Person(names[0], names[1]));
        }

        sc.close();

        Collections.sort(people);

        HashSet<String> firstNameSet = findMatchingFirstNames(people);

        // print out people
        for (int j = 0; j < people.size(); j++) {
            if (firstNameSet.contains(people.get(j).getFirstName())) {
                System.out.println(people.get(j));
            } else {
                System.out.println(people.get(j).getFirstName());
            }
        }
    }

    private static HashSet<String> findMatchingFirstNames(ArrayList<Person> people) {
        var set = new HashSet<String>();
        for (int i = 0; i < people.size() - 1; i++) {
            Person p1 = people.get(i);
            for (int j = i + 1; j < people.size(); j++) {
                Person p2 = people.get(j);
                if (p1.getFirstName().equals(p2.getFirstName())) {
                    set.add(p1.getFirstName());
                    break;
                }
            }
        }
        return set;
    }

}

class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        int lastCompare = this.lastName.compareTo(o.lastName);
        if (lastCompare == 0) {
            return this.firstName.compareTo(o.firstName);
        }
        return lastCompare;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
