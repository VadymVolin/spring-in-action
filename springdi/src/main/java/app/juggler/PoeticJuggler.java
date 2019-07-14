package app.juggler;

import app.performer.exception.PerformerException;
import app.poem.Poem;

public class PoeticJuggler extends Juggler {

	private Poem poem;
	
	public PoeticJuggler (Poem poem) {
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler (int beansBags, Poem poem) {
		super(beansBags);
		this.poem = poem;
	}

	public PoeticJuggler (int beansBags, String beansBags2, Poem poem) {
		super(beansBags, beansBags2);
		this.poem = poem;
	}
	
	public void perform() throws PerformerException {
		super.perform();
		System.out.println("While reciting ...");
		poem.recite();
	}
	
}
