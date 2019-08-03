package app.annotation.withoutbeans.instrument;

import org.springframework.stereotype.Component;

//@Component
public class Cymbal implements Instrument {
	
	public Cymbal() {
		
	}

	public void play() {
		System.out.println("Tilken tilken tilken");
	}

	@Override
	public String toString() {
		return "cymbal";
	}
}
