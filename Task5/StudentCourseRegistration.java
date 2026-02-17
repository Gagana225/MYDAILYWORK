import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity;
    int enrolled = 0;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    boolean isAvailable() {
        return enrolled < capacity;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class StudentCourseRegistration {
    static List<Course> courses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Course database
        courses.add(new Course("CS101", "Java Basics", "Intro to Java", 2, "Mon 10AM"));
        courses.add(new Course("CS102", "DSA", "Data Structures", 2, "Tue 11AM"));
        courses.add(new Course("CS103", "DBMS", "Database Systems", 2, "Wed 12PM"));

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        int choice;
        do {
            System.out.println("\n1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showCourses();
                    break;
                case 2:
                    registerCourse(student);
                    break;
                case 3:
                    dropCourse(student);
                    break;
            }
        } while (choice != 4);

        System.out.println("Thank you!");
    }

    static void showCourses() {
        for (Course c : courses) {
            System.out.println(c.code + " - " + c.title +
                    " | Slots Left: " + (c.capacity - c.enrolled));
        }
    }

    static void registerCourse(Student s) {
        System.out.print("Enter Course Code: ");
        String code = sc.next();

        for (Course c : courses) {
            if (c.code.equalsIgnoreCase(code) && c.isAvailable()) {
                s.registeredCourses.add(c);
                c.enrolled++;
                System.out.println("Registered Successfully!");
                return;
            }
        }
        System.out.println("Course Full or Not Found!");
    }

    static void dropCourse(Student s) {
        System.out.print("Enter Course Code to Drop: ");
        String code = sc.next();

        for (Course c : s.registeredCourses) {
            if (c.code.equalsIgnoreCase(code)) {
                s.registeredCourses.remove(c);
                c.enrolled--;
                System.out.println("Course Dropped!");
                return;
            }
        }
        System.out.println("Not Registered in this Course!");
    }
}
