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
	
	public Juggler(String beanBags) {
		System.out.println("III waant to say " + beanBags);;
	}
	
	public Juggler(int beanBags, String beanBags1) {
		this.beanBags = beanBags;
		System.out.println("III waant to say " + beanBags1);
	}

	public void perform() throws PerformerException {
		System.out.println("Juggling " + beanBags + " beanbags");
	}

}
