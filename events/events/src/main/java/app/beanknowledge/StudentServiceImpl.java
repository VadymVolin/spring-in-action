package app.beanknowledge;

import app.course.Course;
import app.course.events.published.CourseFullEvent;
import app.course.events.published.OnAddEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StudentServiceImpl implements StudentService, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void enrollStudentInCourse(Course course, Student student) throws StudentException {
        boolean added = course.add(student);
        if (added) {
            context.publishEvent(new OnAddEvent(this, course));
        } else {
            context.publishEvent(new CourseFullEvent(this, course));
        }
    }

    public ApplicationContext getContext() {
        return context;
    }
}
