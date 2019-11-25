package jdbc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spitter.data.Spitter;
import spitter.data.jpa.SpitterDAO;
import spitter.services.SpitterServiceImpl;

public class JpaSpringTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/spring/Spring-module.xml");

    Spitter spitter = new Spitter("userJpaTest", "jpaTestPassword", "jpaTestFullname");

    @Test
    public void testAll() {
        SpitterServiceImpl service = (SpitterServiceImpl) context.getBean("spitterServiceImpl");
        service.saveSpitter(spitter);
        Spitter findElem = service.findSpitter(spitter.getId());
        System.out.println("Find elem : " + findElem);
        findElem.setUserName("newTestName");
        findElem.setPassword("newTestPass");
        findElem.setFullName("newTestFullName");
        service.editSpitter(findElem);
        Spitter findAfteUpdate = service.findSpitter(findElem.getId());
        System.out.println(findAfteUpdate);
        service.deleteSpitter(spitter);
        System.out.println("find after delete :" + service.findSpitter(spitter.getId()));
        System.out.println("-----------------------------------------------");

    }

}
