package section3_apis.part2_collections;

import java.util.*;


/**
 * YOUR CHALLENGE:
 * This class only contains a so-called public API. There is no underlying code that supports the API.
 * It is your task to implement this logic. Using the right collection type(s).
 */
public class StudentAdmin {

    private final List<Student> students = new LinkedList<>();
    private final List<Course> courses = new LinkedList<>();

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void AddCourse(Course course) {
        courses.add(course);
    }

    /**
     * Returns the students that are present in the database.
     * If the searchString is * (a wildcard), all students will be returned. Else,
     * a simple case insensitive substring match to both first name and family name will be performed.
     *
     * @param searchString the substring string to look for
     * @return students
     */
    public List<Student> getStudents(String searchString) {
        //YOUR CODE HERE (and remove the throw statement)
        if (Objects.equals(searchString, "*"))
            return Collections.unmodifiableList(students);

        List<Student> filteredStudents = new LinkedList<>();
        for (Student student : students) {
            if (student.getFirstName().toLowerCase().contains(searchString.toLowerCase())
                    || student.getLastName().toLowerCase().contains(searchString.toLowerCase()))
                filteredStudents.add(student);
        }
        return Collections.unmodifiableList(filteredStudents);
    }

    /**
     * Returns the grade of a student for the given course
     *
     * @param student the student
     * @param course  the course
     * @return grade
     */
    public double getGrade(Student student, Course course) {
        //YOUR CODE HERE (and remove the throw statement)

        for(Course c : courses) {
                if(student.getStudentId() == c.getStudent() && Objects.equals(c.getCourseId(), course.getCourseId()))
                    return c.getGrade();
        }
        return 0;
    }

    /**
     * returns all grades for a student, as [key=CourseID]:[value=Grade] Map
     *
     * @param student the student to fetch grades for
     * @return grades
     */
    public Map<String, Double> getGradesForStudent(Student student) {
        //YOUR CODE HERE (and remove the throw statement)
        List<Course> studentCourses = courses
                .stream()
                .filter(x-> x.getStudent() == student.getStudentId())
                .toList();
        Map<String, Double> grades = new HashMap<>();

        for(Course c : studentCourses) {
            grades.put(c.getCourseId(), c.getGrade());
        }

        return Collections.unmodifiableMap(grades);
    }

    /**
     * Returns all grades for a course, as [key=Student]:[value=Grade] Map
     *
     * @param course the course
     * @return grades
     */
    public Map<Student, Double> getGradesForCourse(Course course) {
        //YOUR CODE HERE (and remove the throw statement)
        List<Course> gradedCourses = courses
                .stream()
                .filter(x-> Objects.equals(x.getCourseId(), course.getCourseId()))
                .toList();
        Map<Student, Double> grades = new HashMap<>();

        for(Course c : gradedCourses) {
            Student mystudent = students
                    .stream()
                    .filter(x-> x.getStudentId() == c.getStudent())
                    .findFirst()
                    .orElse(null);
            grades.put(mystudent,c.getGrade());
        }

        return Collections.unmodifiableMap( grades);
    }
}
