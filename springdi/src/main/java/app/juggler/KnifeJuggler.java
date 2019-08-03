package app.juggler;

import app.knife.Knife;
import app.performer.exception.PerformerException;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.HashSet;
import java.util.Set;

public class KnifeJuggler extends Juggler {

    Set<Knife> knives;

    @Inject
    public KnifeJuggler(Provider<Knife> knifeProvider) {
        knives = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            knives.add(knifeProvider.get());
        }
    }

    @Override
    public void perform() throws PerformerException {
        System.out.println("KnifeJuggler juggling by " + knives.size() + " knives.");
    }
}
