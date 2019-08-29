package jdbc.standart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.standartjdbc.SpitterDAO;

public class StandartJdbcTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/standart/Spring-module.xml");

    @Test
    public void testInsert() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        spitterDAO.insert(new Spitter("Vlad", "vlad123", "Vlad Volin"));
    }

    @Test
    public void testSelect() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
            System.out.println(spitterDAO.findById(15));
    }

}
