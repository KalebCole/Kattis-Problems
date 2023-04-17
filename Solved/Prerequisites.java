import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Prerequisites {
    static Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) throws Exception {
        
        while (true) {
            String line = io.getLine();
            if(line.equals("0")) return;
            int courses = Integer.parseInt(line.substring(0, line.indexOf(" ")));
            int categories = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            String[] freddieCourses = new String[courses];
            String[] courseArr = io.getLine().split(" ");
            for (int i = 0; i < courseArr.length; i++) {
                freddieCourses[i] = courseArr[i];
            }

            
            Category[] categoryArr = new Category[categories];
            for (int i = 0; i < categories; i++) {
                String[] categoryLine = io.getLine().split(" ");
                Category category = new Category(categoryLine[0], categoryLine[1]);
                for (int j = 2; j < categoryLine.length; j++) {
                    category.addCourse(categoryLine[j]);
                }
                categoryArr[i] = category;
            }

            // start checking if prereqs
            boolean isValid = true;
            for (int i = 0; i < categoryArr.length; i++) {
                if(!categoryArr[i].checkCourses(freddieCourses)) isValid = false;
            }
            if(isValid) System.out.println("yes");
            else System.out.println("no");

        }
    }
}

class Category {
    public int totalCourses;
    public int minCoursesToTake;
    public ArrayList<String> courses;

    public Category(String totalCourses, String minCoursesToTake) {
        this.totalCourses = Integer.parseInt(totalCourses);
        this.minCoursesToTake = Integer.parseInt(minCoursesToTake);
        courses = new ArrayList<>();
    }

    public boolean checkCourses(String[] freddieCourses) {
        int minCount = 0;
        for (String course : courses) {
            for (String freddieCourse : freddieCourses) {
                if(course.equals(freddieCourse)) minCount++;
            }
        }
        if(minCount >= minCoursesToTake) return true;
        return false;
    }

    public void addCourse(String course) {
        courses.add(course);
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String getLine() throws Exception {
        return r.readLine();
    }

    public void printLine(String line) {
        this.print(line);
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
