import app.aspects.annotationaspect.contestant.Contestant;
import app.aspects.annotationaspect.mindreader.MindReader;
import app.aspects.annotationaspect.mindreader.Thinker;
import app.performer.Performer;
import app.performer.exception.PerformerException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringAnnotationTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "beans/idolbeans.xml", "beans/autoInj.xml", "beans/annotation.xml", "beans/withoutbeans.xml");


    @Test
    public void testAnnotationAspectMindReader() {

        Thinker annotationVolunteer =
                (Thinker) ctx.getBean("annotationVolunteer");
        MindReader annotMindReader =
                (MindReader) ctx.getBean("annotationMagicianReader");
        annotationVolunteer.thinkOfSomething("I think for @aspect magicReader");
        assertEquals(annotationVolunteer.getThoughts(), annotMindReader.getThoughts());
    }

    @Test
    public void annotationContestantDelegate() throws PerformerException {
        Performer kenny = (Performer) ctx.getBean("kenny");
        kenny.perform();
        ((Contestant) kenny).receiveAward();
    }

}
