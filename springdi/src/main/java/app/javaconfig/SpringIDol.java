package app.javaconfig;

import app.javaconfig.instrument.Guitar;
import app.javaconfig.juggler.PoeticJuggler;
import app.javaconfig.performer.Performer;
import app.javaconfig.juggler.Juggler;
import app.javaconfig.instrumental.Instrumentalist;
import app.javaconfig.poem.Poem;
import app.javaconfig.sonnet.Sonnet29;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIDol {

    @Bean
    public Performer duke() {
        System.out.println("create standard duke");
        return new Juggler();
    }

    @Bean
    public Performer duke15 () {
        System.out.println("create duke15");
        return new Juggler(15);
    }

    @Bean
    public Performer kenny () {
        Instrumentalist kenny = new Instrumentalist();
        kenny.setInstrument(guitar());
        kenny.setName("Kenny");
        kenny.setSong("All eyes on mee");
        System.out.println("create kenny instrumentalist");
        return kenny;
    }

    @Bean
    public Guitar guitar() {
        System.out.println("create guitar");
        return new Guitar();
    }

    @Bean
    public Poem sonnet29 () {
        return new Sonnet29();
    }

    @Bean
    public Performer poeticDuke() {
        System.out.println("create poetic duke");
        return new PoeticJuggler(sonnet29());
    }

}
