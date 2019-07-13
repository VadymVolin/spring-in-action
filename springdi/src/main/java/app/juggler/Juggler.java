package app.juggler;

import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Juggler implements Performer {
	
	private int beanBags = 3;
	
	public Juggler() {
		beanBags = 3;
	}
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	public void perform() throws PerformerException {
		System.out.println("Juggling " + beanBags + " beanbags");
	}

}
