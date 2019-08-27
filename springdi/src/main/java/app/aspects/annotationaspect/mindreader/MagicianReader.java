package app.aspects.annotationaspect.mindreader;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MagicianReader implements MindReader {
    private String thoughts;

    @Pointcut("execution(* app.aspects.annotationaspect.mindreader.Thinker.thinkOfSomething(String))" +
            "&& args(thoughts)")
    public void thinking(String thoughts) {

    }

    @Override
    @After(value = "thinking(thoughts)", argNames = "thoughts")
    public void interceptThoughts(String thoughts) {
        System.out.println("Method from @aspect magicreader");
        System.out.println("Intercepting volonteers thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
