package app;

import app.course.Course;
import app.course.events.published.CourseFullEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("event.xml");

        Course course = (Course) ctx.getBean("course");
        ctx.publishEvent(new CourseFullEvent(ctx, course));
    }
}
