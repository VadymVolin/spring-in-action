package app.annotation.withoutbeans.instrument;

import org.springframework.stereotype.Component;

//@Component
public class Saxophone implements Instrument {

	public Saxophone() {}
	
	public void play() {
		System.out.println("Toot Toot Toot");
	}

	@Override
	public String toString() {
		return "saxophone";
	}
}
