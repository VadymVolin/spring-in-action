package fuddlang;

import fuddlang.human.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FuddLang {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("fudd.xml");
        Human john = (Human) ctx.getBean("john");
        System.out.println (john.getName() + " say - " + john.getSpeech());
    }

}
