package app;

import app.beanknowledge.Student;
import app.beanknowledge.StudentException;
import app.beanknowledge.StudentServiceImpl;
import app.course.Course;
import app.course.events.published.CourseFullEvent;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/event.xml");

        Course course = (Course) ctx.getBean("course");

        List<Student> students = (List<Student>) ctx.getBean("students");
        StudentServiceImpl studentsImpl = (StudentServiceImpl) ctx.getBean("studentsImpl");
        System.out.println(studentsImpl.getContext());
        for (Student std : students) {
            try {
                studentsImpl.enrollStudentInCourse(course, std);
            } catch (StudentException e) {
                e.printStackTrace();
            }
        }
    }
}
