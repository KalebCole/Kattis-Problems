public class Attendence {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int numberOfNames = io.getInt();
        String[] names = new String[numberOfNames];
        int x = 0;
        for (int i = 0; i < names.length; i++) {
            names[i] = io.getWord();
        }
        
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals("Present!")){
                names[i] = "";
                names[i-1] = "";
            }
        }

        for (int i = 0; i < names.length; i++) {
            if(!(names[i].equals(""))){
                System.out.println(names[i]);
                x++;
            }
        }

        if(x == 0) System.out.println("No absences");
    }
}
