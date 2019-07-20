package app.course;

public class Course {

    private String description;

    public Course(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "init course + - " + description;
    }
}