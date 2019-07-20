package app.course.events.published;

import org.springframework.context.ApplicationEvent;

import app.course.Course;

public class CourseFullEvent extends ApplicationEvent {

    private Course course;

    public CourseFullEvent(Object source, Course course) {
        super(source);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}