package jdbc.standart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.standartjdbc.withouthibernate.SpitterDAO;

public class StandartJdbcTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/standart/Spring-module.xml");
    private Spitter spitter = new Spitter(22, "Vlad", "vlad123", "Vlad Volin");

    @Test
    public void testInsert() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        spitterDAO.insert(spitter);
    }

    @Test
    public void testSelect() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        System.out.println(spitterDAO.findById(spitter.getId()));
    }

    @Test
    public void testDelete() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        spitterDAO.delete(spitter);
    }

}
