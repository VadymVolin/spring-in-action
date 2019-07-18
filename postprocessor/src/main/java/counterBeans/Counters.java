package counterBeans;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Counters {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("counter.xml");
        BeanCounter beanCounter = (BeanCounter) ctx.getBean("beanCounter");
    }

}
