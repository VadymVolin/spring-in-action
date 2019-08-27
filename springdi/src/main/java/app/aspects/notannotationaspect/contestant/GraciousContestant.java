package app.aspects.notannotationaspect.contestant;

public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("I receive award");
    }
}
