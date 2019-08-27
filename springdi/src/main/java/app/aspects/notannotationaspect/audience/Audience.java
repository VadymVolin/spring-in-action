package app.aspects.notannotationaspect.audience;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

//    before performance
    public void takeSeats() {
        System.out.println("The audience it taking their seats");
    }

//    before performance
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

//    after cool performance
    public void applaud() {
        System.out.println("Clap Clap Clap Clap");
    }

//    after bad performance
    public void demandRefund() {
        System.out.println("OOOOoooooo!! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinpoint) {
        try {
            System.out.println("The audience it taking their seats");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinpoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("Clap Clap Clap Clap");
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable throwable) {
            System.out.println("OOOOoooooo!! We want our money back!");
        }
    }

}
