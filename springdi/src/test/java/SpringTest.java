import app.mindreader.MindReader;
import app.mindreader.Thinker;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringTest {

    @Test
    public void magicianShouldREadVolunteersMind() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "beans/idolbeans.xml", "beans/autoInj.xml", "beans/annotation.xml", "beans/withoutbeans.xml");
        Thinker volunteer = (Thinker) ctx.getBean("volunteer");
        MindReader magicianrReader = (MindReader) ctx.getBean("magicianReader");
        //        volunteer.thinkOfSomething("queen of hearts");
        volunteer.thinkOfSomething("queen of my life");

        assertEquals(volunteer.getThoughts(), magicianrReader.getThoughts());
    }

}
