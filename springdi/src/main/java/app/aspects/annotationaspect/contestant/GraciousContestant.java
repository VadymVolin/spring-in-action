package app.aspects.annotationaspect.contestant;

public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("@aspect and @DeclareParents - I receive award");
    }
}
