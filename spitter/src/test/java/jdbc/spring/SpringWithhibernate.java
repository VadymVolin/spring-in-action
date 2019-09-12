package jdbc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.springjdbc.springplushibernate.SpitterDAO;

public class SpringWithhibernate {
    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/spring/Spring-module.xml");
    private Spitter spitter = new Spitter("user", "password", "fullname");

    @Test
    public void testAdd() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        dao.addSpitter(spitter);
    }

    @Test
    public void testList() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        System.out.println(dao.list());
    }


    @Test
    public void testGet() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        System.out.println(dao.findById(spitter.getId()));
    }

    @Test
    public void testDelete() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        dao.delete(spitter);
    }
}
