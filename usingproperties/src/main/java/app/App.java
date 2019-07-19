package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Locale;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("components/components.xml");

//        properties link
        Object dataSource = ctx.getBean("dataSource");
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        System.out.println(dataSource.toString());

//        properties message
        String message = ctx.getMessage("computer", new Object[0], new Locale("es_MX"));
        String message1 = ctx.getMessage("student", new Object[0], new Locale("es_MX"));
        System.out.println(message + " | " + message1);
    }

}