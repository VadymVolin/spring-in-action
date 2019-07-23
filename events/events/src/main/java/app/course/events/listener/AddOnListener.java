package app.course.events.listener;

import app.course.events.published.CourseFullEvent;
import app.course.events.published.OnAddEvent;
import org.springframework.context.ApplicationListener;

public class AddOnListener implements ApplicationListener<OnAddEvent> {

    public void onApplicationEvent(OnAddEvent event) {
        System.out.println("add student " + event.getLastAdd() + " on course -|" + event.getCourse().getDescription());
    }

}