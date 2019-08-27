package app.aspects.annotationaspect.contestant;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

//    introduce interface Contestant
    @DeclareParents(value = "app.performer.Performer+",
            defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
