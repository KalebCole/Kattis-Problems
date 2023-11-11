/* 
 * Needed to add an ID because duplicates will be erased in a TreeSet 
 */

import java.util.Scanner;
import java.util.TreeSet;

public class AssigningWorkstations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int m = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
        TreeSet<Researcher> researchers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            int arrival = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            int stay = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            Researcher researcher = new Researcher(arrival, arrival + stay);
            researchers.add(researcher);
        }
        System.out.println(countAssignments(researchers, m));
    }

    public static int countAssignments(TreeSet<Researcher> researchers, int minutesOfInactivity) {
        int count = 0;
        TreeSet<Workstation> workstations = new TreeSet<>();
        for (Researcher researcher : researchers) {
            // no workstations available
            if (workstations.size() == 0) {
                workstations.add(new Workstation(researcher.arrivalTime, researcher.endTime));
                continue;
            }

            // get first available workstation
            while (workstations.size() != 0) {
                Workstation workstation = workstations.pollFirst();
                if (workstation.endTime + minutesOfInactivity < researcher.arrivalTime) {
                    continue;
                } else if (workstation.endTime > researcher.arrivalTime) {
                    workstations.add(new Workstation(researcher.arrivalTime, researcher.endTime));
                } else {
                    count++;
                    // update the workstation for the new researcher
                    workstation.startTime = researcher.arrivalTime;
                    workstation.endTime = researcher.endTime;
                }
                workstations.add(workstation);
                break;

            }

        }

        return count;
    }

}

// need an ID because if they end at the same time, then they are equal
class Workstation implements Comparable<Workstation> {
    public int id;
    public int startTime;
    public int endTime;
    public static int count = 1;

    public Workstation(int startTime, int endTime) {
        this.id = count;
        // increase a count every time
        count += 1;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Workstation o) {
        // need to order based on endtime
        if (this.endTime != o.endTime)
            return this.endTime - o.endTime;
        else
            return this.id - o.id;
    }

}

class Researcher implements Comparable<Researcher> {
    public int id;
    public static int count = 1;
    public int arrivalTime;
    public int endTime;

    public Researcher(int arrivalTime, int endTime) {
        this.id = count++;
        this.arrivalTime = arrivalTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Researcher o) {
        // order based on arrival time
        if (this.arrivalTime != o.arrivalTime)
            return this.arrivalTime - o.arrivalTime;
        else
            return this.id - o.id;
    }

}
