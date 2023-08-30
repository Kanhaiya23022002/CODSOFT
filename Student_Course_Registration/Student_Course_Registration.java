import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String studentName;
    private List<Course> registeredCourses;

    public Student(String studentName) {
        this.studentName = studentName;
        registeredCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course " + course.getCourseCode() + " registered successfully.");
    }
}

public class Student_Course_Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Course> courses = new HashMap<>();
        List<Student> students = new ArrayList<>();

        
        courses.put("CS101", new Course("CS101", "Introduction to Computer Science"));
        courses.put("MATH202", new Course("MATH202", "Linear Algebra"));

        while (true) {
            System.out.println("1. Register a student");
            System.out.println("2. Register for a course");
            System.out.println("3. View registered courses");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    students.add(new Student(studentName));
                    System.out.println("Student " + studentName + " registered.");
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = null;
                    for (Student s : students) {
                        if (s.getStudentName().equals(name)) {
                            student = s;
                            break;
                        }
                    }
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    Course selectedCourse = courses.get(courseCode);
                    if (selectedCourse == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    student.registerCourse(selectedCourse);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String stuName = scanner.nextLine();
                    Student stu = null;
                    for (Student s : students) {
                        if (s.getStudentName().equals(stuName)) {
                            stu = s;
                            break;
                        }
                    }
                    if (stu == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("Registered courses for " + stu.getStudentName() + ":");
                    for (Course c : stu.getRegisteredCourses()) {
                        System.out.println(c.getCourseCode() + " - " + c.getCourseName());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }
        }
    }
}
