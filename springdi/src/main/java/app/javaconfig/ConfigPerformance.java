package app.javaconfig;

import app.javaconfig.performer.Performer;
import app.javaconfig.performer.exception.PerformerException;

public class ConfigPerformance {

    public static void main(String[] args) {
        SpringIDol context = new SpringIDol();
        Performer duke = context.duke();
        Performer poetDuke = context.poeticDuke();
        Performer duke15 = context.duke15();
        Performer kenny = context.kenny();

        try {
            duke.perform();
            duke15.perform();
            poetDuke.perform();

            System.out.println(kenny.toString());
            kenny.perform();
        } catch (PerformerException e) {
            e.printStackTrace();
        }
    }

}
