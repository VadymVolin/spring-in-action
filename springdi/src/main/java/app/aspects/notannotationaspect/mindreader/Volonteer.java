package app.aspects.notannotationaspect.mindreader;

public class Volonteer implements Thinker {

    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        System.out.println("volunteer think about smth");
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
