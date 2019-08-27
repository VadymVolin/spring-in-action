package app.judge;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public aspect JudgeAspect {

    public JudgeAspect() {}

    pointcut performance() : execution(* perform(..));

    after() returning() : performance() {
            System.out.println(criticismEngine.getCriticism());
        }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
        }
}
