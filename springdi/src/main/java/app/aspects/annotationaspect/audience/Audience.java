package app.aspects.annotationaspect.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// create another class Audience with annotation for aspect
@Aspect
public class Audience {

    @Pointcut("execution(* app.performer.Performer.perform(..))")
    public void performance() {

    }

    //    before performance
//    @Before("performance()")
    public void takeSeats() {
        System.out.println("Method from audience wit @aspectJ annotation\r\nThe audience it taking their seats");
    }

    //    before performance
//    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("Method from audience wit @aspectJ annotation\nThe audience is turning off their cellphones");
    }

    //    after cool performance
//    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("Method from audience wit @aspectJ annotation\nClap Clap Clap Clap");
    }

    //    after bad performance
//    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Method from audience wit @aspectJ annotation\nOOOOoooooo!! We want our money back!");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinpoint) {
        try {
            System.out.println("@aspectJ annotation - The audience it taking their seats");
            System.out.println("@aspectJ annotation - The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinpoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("@aspectJ annotation - Clap Clap Clap Clap");
            System.out.println("@aspectJ annotation - The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable throwable) {
            System.out.println("@aspectJ annotation - OOOOoooooo!! We want our money back!");
        }
    }

}
