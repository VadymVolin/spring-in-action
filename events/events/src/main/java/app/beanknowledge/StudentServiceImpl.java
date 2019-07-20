package app.beanknowledge;

import app.course.Course;
import app.course.events.published.CourseFullEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StudentServiceImpl implements StudentService, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = context;
    }

    public void enrollStudentInCourse(Course course, Student student) throws StudentException {

        context.publishEvent(new CourseFullEvent(this, course));
    }
}
