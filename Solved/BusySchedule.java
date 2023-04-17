import java.util.Arrays;
import java.util.Scanner;

class BusySchedule {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Time[] times = new Time[n];
			for (int i = 0; i < n; i++) {// fill array
				times[i] = new Time(sc.next(), sc.next());
			}

			Arrays.sort(times);
			for (int j = 0; j < n; j++) {
				System.out.println(times[j]);
			}
			System.out.println();
		}

		sc.close();

	}

}

class Time implements Comparable<Time> {
	int hours;
	int mins;

	public Time(String time, String format) {
		hours = Integer.parseInt(time.substring(0, time.indexOf(":")));
		mins = Integer.parseInt(time.substring(time.indexOf(":") + 1));
		if (hours == 12) {
			hours = 0;
		}
		if (format.equals("p.m.")) {
			hours += 12;
		}
	}

	@Override
	public int compareTo(Time o) {
		if (this.hours < o.hours) {
			return -1;
		} else if (this.hours > o.hours) {
			return 1;
		} else {
			if (this.mins < o.mins) {
				return -1;
			} else if (this.mins > o.mins) {
				return 1;
			} else {
				return 0;
			}

		}
	}

	@Override
	public String toString() {
		if (hours > 12) { //p.m. hours
			if (mins == 0)
				return (hours - 12) + ":" + mins + "0 p.m.";
			else if (mins < 10)
				return (hours - 12) + ":0" + mins + " p.m.";
			else
				return (hours - 12) + ":" + mins + " p.m.";
		} else if (hours == 12) {
			if (mins == 0)
				return hours + ":" + mins + "0 p.m.";
			else if (mins < 10)
				return hours + ":0" + mins + " p.m.";
			else
				return hours + ":" + mins + " p.m.";
		} else if (hours == 0) { //12 a.m.
			if (mins == 0)
				return 12 + ":" + mins + "0 a.m.";
			else if (mins < 10)
				return 12 + ":0" + mins + " a.m.";
			else
				return 12 + ":" + mins + " a.m.";
		} else { //a.m. hours
			if (mins == 0)
				return hours + ":" + mins + "0 a.m.";
			else if (mins < 10)
				return hours + ":0" + mins + " a.m.";
			else
				return hours + ":" + mins + " a.m.";
		}
	}

}
