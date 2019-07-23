package app.course.events.published;

import app.beanknowledge.Student;
import app.course.Course;
import org.springframework.context.ApplicationEvent;

public class OnAddEvent extends ApplicationEvent {

    private Course course;

    public OnAddEvent(Object source, Course course) {
        super(source);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public Student getLastAdd() {
        return course.getAddedStudent();
    }
}
