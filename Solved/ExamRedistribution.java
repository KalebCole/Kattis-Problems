import java.util.Arrays;
import java.util.Scanner;

class ExamRedistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rooms = new int[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = sc.nextInt();
        }

        examRedistribution(rooms);
    }

    public static void examRedistribution(int[] rooms) {
        Room[] roomClasses = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            roomClasses[i] = new Room(i+1, rooms[i]);
        }

        // find max and sum of the array
        int max = 0, sum = 0;
        for (int i = 0; i < rooms.length; i++) {
            if(max < rooms[i]){
                max = rooms[i];
            }
            sum += rooms[i];
        }
        sum -= max;

        // there is not an even amount of exams and some people will be reviewing their own
        if(max > sum){
            System.out.println("impossible");
            return;
        }
        // lambda expression that sorts based on the values of the rooms
        Arrays.sort(roomClasses, (r1, r2) -> r2.value - r1.value);
        
        for (int i = 0; i < roomClasses.length; i++) {
            System.out.print(roomClasses[i].index);
            if(i!= roomClasses.length-1) System.out.print(" ");
        }
        


    }
}

class Room {
    public int index;
    public int value;


    public Room(int index, int value){
        this.index = index;
        this.value = value;
    }



}
