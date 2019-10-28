package jdbc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.jpa.SpitterDAO;

public class JpaSpringTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/spring/Spring-module.xml");

    Spitter spitter = new Spitter("userJpaTest", "jpaTestPassword", "jpaTestFullname");

    @Test
    public void testAll() {
        SpitterDAO dao = (SpitterDAO) context.getBean("jpaSpitterDao");
        dao.addSpitter(spitter);
        Spitter findElem = dao.findById(spitter.getId());
        System.out.println("Find elem : " + findElem);
        findElem.setUserName("newTestName");
        findElem.setPassword("newTestPass");
        findElem.setFullName("newTestFullName");
        dao.updateSpitter(findElem);
        Spitter findAfteUpdate = dao.findById(findElem.getId());
        System.out.println(findAfteUpdate);
        dao.delete(spitter);
        System.out.println("find after delete :" + dao.findById(spitter.getId()));
        System.out.println("-----------------------------------------------");

    }

}
