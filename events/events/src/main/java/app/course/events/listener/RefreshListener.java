package app.course.events.listener;

import app.course.events.published.CourseFullEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class RefreshListener implements ApplicationListener<CourseFullEvent> {

    public void onApplicationEvent(CourseFullEvent event) {
        System.out.println("we see event!!!");
        System.out.println(event.getCourse().getDescription());
    }

}