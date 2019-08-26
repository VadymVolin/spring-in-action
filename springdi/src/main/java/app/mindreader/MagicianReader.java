package app.mindreader;

public class MagicianReader implements MindReader{
    private String thoughts;

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volonteers thoughts");
        this.thoughts = thoughts;
        System.out.println(thoughts);
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
