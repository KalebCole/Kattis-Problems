public class HangingOutOnTheTerrace {
    static Kattio sc = new Kattio(System.in);

    public static void main(String[] args) {
        int max = sc.getInt(), timesEntering = sc.getInt();
        int count = 0, currentPeopleInBuilding = 0;
        for (int i = 0; i < timesEntering; i++) {
            if (sc.getWord().equals("enter")) {
                int temp = sc.getInt();
                if (currentPeopleInBuilding + temp > max) {
                    count++;
                } else {
                    currentPeopleInBuilding += temp;
                }
            } else {
                currentPeopleInBuilding -= sc.getInt();
            }
        }
        System.out.println(count);
    }
}
