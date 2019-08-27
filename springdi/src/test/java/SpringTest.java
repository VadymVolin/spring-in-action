import app.aspects.notannotationaspect.contestant.Contestant;
import app.aspects.notannotationaspect.mindreader.MindReader;
import app.aspects.notannotationaspect.mindreader.Thinker;
import app.performer.Performer;
import app.performer.exception.PerformerException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "beans/idolbeans.xml", "beans/autoInj.xml", "beans/annotation.xml", "beans/withoutbeans.xml");

    @Test
    public void magicianShouldReadVolunteersMind() {
        Thinker volunteer = (Thinker) ctx.getBean("volunteer");
        MindReader magicianrReader = (MindReader) ctx.getBean("magicianReader");
        volunteer.thinkOfSomething("queen of my life");

        assertEquals(volunteer.getThoughts(), magicianrReader.getThoughts());
    }

    @Test
    public void testContestantDelegate() throws PerformerException {
        Performer kenny = (Performer) ctx.getBean("kenny");
        kenny.perform();
        ((Contestant) kenny).receiveAward();

    }

    @Test
    public void testAnnotationAspectMindReader() {

        app.aspects.annotationaspect.mindreader.Thinker annotationVolunteer =
                (app.aspects.annotationaspect.mindreader.Thinker) ctx.getBean("annotationVolunteer");
        app.aspects.annotationaspect.mindreader.MindReader annotMindReader =
                (app.aspects.annotationaspect.mindreader.MindReader) ctx.getBean("annotationMagicianReader");
        annotationVolunteer.thinkOfSomething("I think for @aspect magicReader");
        assertEquals(annotationVolunteer.getThoughts(), annotMindReader.getThoughts());
    }

}
