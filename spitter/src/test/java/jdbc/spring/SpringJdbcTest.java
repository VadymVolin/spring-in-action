package jdbc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.springjdbc.springdaosupport.SpitterDAO;

public class SpringJdbcTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/spring/Spring-module.xml");

    @Test
    public void testInsert() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        for (char i = 'a'; i < 'z'; i++) {
            spitterDAO.addSpitter(new Spitter(String.valueOf(i), String.valueOf(i + 12345), String.valueOf(i + i + i)));
        }
    }

    @Test
    public void testSelectById() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
            System.out.println(spitterDAO.findById(406126592));
    }

    @Test
    public void testSelectByIdWithRowMapper() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
            System.out.println(spitterDAO.findById(406126592));
    }

    @Test
    public void testSelectByUserName() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        System.out.println(spitterDAO.findByUserName("l"));

    }

    @Test
    public void testDeleteById() {
        SpitterDAO spitterDAO = (SpitterDAO) context.getBean("spitterDAO");
        System.out.println(spitterDAO.deleteById(406126592));
    }

}
