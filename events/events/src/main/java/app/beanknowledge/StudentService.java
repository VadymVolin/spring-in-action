package app.beanknowledge;

import app.course.Course;

public interface StudentService {

    void enrollStudentInCourse(Course course, Student student) throws StudentException;

}
