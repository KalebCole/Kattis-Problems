import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

class CutTheNegativity{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<>();
        int n = sc.nextInt(), temp = 0, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = sc.nextInt();
                if (temp == -1) continue;
                count++;
                flights.add(new Flight(i+1, j+1, temp)); // depart, land, cost
            }
        }
        flights.sort(new FlightComparator());

        System.out.println(count);
        printList(flights);

    }

    public static void printList(ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            System.out.printf("%d %d %d \n", flight.depart, flight.land, flight.cost);
        }
    }

}

class FlightComparator implements Comparator<Flight>{
    @Override
    public int compare(Flight o1, Flight o2) {
        if(o1.depart < o2.depart) return -1;
        else if(o1.depart > o2.depart) return 1;
        else{
            if(o1.land < o2.land) return -1;
            else if(o1.land > o2.land) return 1;
            else return 0;
        }
        
    }    
}

class Flight {
    public int depart;
    public int land;
    public int cost;

    Flight(int depart, int land, int cost) {
        this.depart = depart;
        this.land = land;
        this.cost = cost;
    }
}
