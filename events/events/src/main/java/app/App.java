package app;

import app.scripting.Coconut;
import app.scripting.Lime;
import app.scripting2.ICoconut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                new String[]{"/event.xml", "/scripting.xml", "/scripting2.xml"}
        );

//        Course course = (Course) ctx.getBean("course");
//
//        List<Student> students = (List<Student>) ctx.getBean("students");
//        StudentServiceImpl studentsImpl = (StudentServiceImpl) ctx.getBean("studentsImpl");
//        System.out.println(studentsImpl.getContext());
//        for (Student std : students) {
//            try {
//                studentsImpl.enrollStudentInCourse(course, std);
//            } catch (StudentException e) {
//                e.printStackTrace();
//            }
//        }

        ICoconut coconut = (ICoconut) ctx.getBean("coconut");
        coconut.drinkThemBothUp();
        Lime lime = (Lime) ctx.getBean("lime");
//        lime.drink();


    }
}
