import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentStreamDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Sai", 82),
            new Student("Prasanna", 68),
            new Student("Kiran", 91),
            new Student("Anjali", 74),
            new Student("Teja", 88)
        );

        System.out.println("Students scoring above 75% (sorted by marks):");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name + " - " + s.marks + "%")
                .forEach(System.out::println);
    }
}
