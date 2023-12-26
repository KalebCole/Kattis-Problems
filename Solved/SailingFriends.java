import java.util.ArrayList;
import java.util.Scanner;

public class SailingFriends {
    public static void main(String[] args) {
        int count = 0;
        Person[] people;
        int[] peopleWithBoats;

        // get inputs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), b = sc.nextInt(), m = sc.nextInt();
        // make People arr
        people = new Person[n];
        for (int i = 1; i <= n; i++) {
            people[i - 1] = new Person(i);
        }
        // add people with boats
        peopleWithBoats = new int[b];
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                peopleWithBoats[i] = sc.nextInt();
            }
        }
        // add friends
        for (int i = 0; i < m; i++) {
            updatePersonWithFriends(people[sc.nextInt() - 1], people[sc.nextInt() - 1]);
        }
        sc.close();

        updatePeopleWithBoats(people, peopleWithBoats);

        // iterate through the list of people with boats and DFS all friends
        for (int i = 0; i < peopleWithBoats.length; i++) {
            DFS(people[peopleWithBoats[i] -  1]);
        }

        // Start DFS but with people buying boats
        for (int i = 0; i < people.length; i++) {
            if (people[i].hasBoat)
                continue;
            count++; // person has bought a boat
            DFS(people[i]); // update all their friends
        }

        System.out.println(count);

    }

    public static void updatePersonWithFriends(Person person, Person friend) {
        // bidirectional
        person.friends.add(friend);
        friend.friends.add(person);
    }

    public static void updatePeopleWithBoats(Person[] people, int[] peopleWithBoats) {
        for (int i = 0; i < peopleWithBoats.length; i++) {
            people[peopleWithBoats[i]-1].hasBoat = true;
        }
    }

    // this is used for friends of people who have boats, so it is just supposed to
    // say they have one
    public static void DFS(Person person) {
        // base case
        // do not create a cycle
        
        if (person.isVisited || (person.isVisited && person.hasBoat))
            return;
        person.hasBoat = true;
        person.isVisited = true;

        // loop through all the friends to change their boat status
        for (Person friend : person.friends) {
            DFS(friend);
        }
    }
}

class Person {
    public int index;
    public ArrayList<Person> friends;
    public boolean isVisited;
    public boolean hasBoat;

    public Person(int index) {
        this.index = index;
        this.friends = new ArrayList<>();
        this.hasBoat = false;
        this.isVisited = false;
    }

}
