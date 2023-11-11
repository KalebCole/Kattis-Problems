import java.util.*;

public class NotAmused {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = 1;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.contains("OPEN")) {
                ArrayList<Customer> customers = new ArrayList<>();
                while (true) {
                    line = sc.nextLine();
                    if (line.contains("CLOSE")) {
                        Collections.sort(customers);
                        printDay(day, customers);
                        break;
                    } else if (line.contains("ENTER")) {
                        if(isInList(line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), customers)){
                            continue;
                        }
                        createCustomer(line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), customers);
                    } else if (line.contains("EXIT")) {
                        calculateBill(line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), customers);
                    }

                }
            }
            day++;
        }
        sc.close();

    }

    private static boolean isInList(String name, int arrival, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                // update arrival time, so when they exit again it will be calculated
                customer.setArrival(arrival);
                return true;
            }
        }
        return false;
    }

    public static void createCustomer(String name, int arrival, ArrayList<Customer> customers) {
        Customer c = new Customer(name, arrival);
        customers.add(c);
    }

    public static void calculateBill(String name, int leave, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                customer.setExit(leave);
                customer.setBill(customer.getBill() + ((customer.getExit() - customer.getArrival()) * .1));
            }
        }
    }

    public static void printDay(int day, ArrayList<Customer> customers) {
        System.out.printf("Day %d\n", day);
        for (Customer customer : customers) {
            System.out.printf("%s $%.2f\n", customer.getName(), customer.getBill());
        }
        System.out.println();
    }
}

class Customer implements Comparable<Customer> {

    private String name;
    private int arrival;
    private int exit;
    private double bill;

    public Customer(String name, int arrival) {
        this.name = name;
        this.arrival = arrival;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }

}
