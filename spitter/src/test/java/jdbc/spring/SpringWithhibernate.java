package jdbc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.springjdbc.springplushibernate.SpitterDAO;

import java.util.Arrays;

public class SpringWithhibernate {
    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/spring/Spring-module.xml");
    Spitter spitter = new Spitter(34432436,"user", "password", "fullname");

    @Test
    public void testAll() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        dao.addSpitter(spitter);
        Spitter findElem = dao.findById(spitter.getId());
        System.out.println("Find elem : " + findElem);
        dao.delete(spitter);
        System.out.println("find after delete :" + dao.findById(spitter.getId()));
    }

    @Test
    public void testAdd() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        dao.addSpitter(spitter);
    }

    @Test
    public void testList() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        for (Object s: dao.list()) {
            System.out.println(s);
        }
    }


    @Test
    public void testGet() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        System.out.println(spitter.getId());
        System.out.println(dao.findById(spitter.getId()));
    }

    @Test
    public void testDelete() {
        SpitterDAO dao = (SpitterDAO) context.getBean("hibernateSpitterDao");
        dao.delete(spitter);
    }
}
