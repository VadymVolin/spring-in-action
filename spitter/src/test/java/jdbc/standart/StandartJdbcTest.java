package jdbc.standart;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.standartjdbc.hibernate.SpitterDAO;
//import spitter.data.standartjdbc.withouthibernate.SpitterDAO;

import javax.persistence.Table;
import java.util.List;

public class StandartJdbcTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/standart/Spring-module.xml");
    private Spitter spitter = new Spitter(4, "Barbara", "barbar", "Barbaris");

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

    @Test
    public void testHibernateInsert() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        spitterDAO.insert(spitter);
    }

    @Test
    public void testListHibernate() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        List<Spitter> spitters = spitterDAO.list();
        System.out.println(spitters);
    }

    @Test
    public void testSelecByIdHibernate() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        System.out.println(spitterDAO.findById(2));
    }

    @Test
    public void testDeleteHibernate() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        spitterDAO.delete(spitter);
    }

}
