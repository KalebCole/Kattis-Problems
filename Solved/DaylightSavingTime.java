import java.util.Scanner;

public class DaylightSavingTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int forwardOrBackward, time, currentHour, currentMinute;
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("F")) {
                forwardOrBackward = 0;
            } else {
                forwardOrBackward = 1;
            }
            time = Integer.parseInt(line[1]);
            currentHour = Integer.parseInt(line[2]);
            currentMinute = Integer.parseInt(line[3]);
            int[] timeArr = Dst(forwardOrBackward, time, currentHour, currentMinute);
            System.out.println(timeArr[0] + " " + timeArr[1]);
        }
    }

    private static int[] Dst(int i, int time, int currentHour, int currentMinute) {
        int currentTime = currentHour * 60 + currentMinute;
        if (i == 1) {
            currentTime -= time;
        } else {
            currentTime += time;
        }

        int[] timeArr = convertBackToTime(currentTime);
        return timeArr;
    }

    private static int[] convertBackToTime(int currentTime) {
        int[] timeArr = new int[2];
        currentTime = currentTime % (24 * 60);
        if (currentTime < 0) {
            currentTime += (24 * 60); // add a day
        }
        timeArr[1] = currentTime % 60; // minutes
        timeArr[0] = (currentTime - timeArr[1]) / 60;
        return timeArr;
    }
}
