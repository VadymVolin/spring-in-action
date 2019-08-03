package app.annotation.withoutbeans.instrument;

import org.springframework.stereotype.Component;

//@Component
public class Piano implements Instrument {

	public Piano () {}
	
	public void play() {
		System.out.println("Plink, Plink, Plink");
	}

	@Override
	public String toString() {
		return "piano";
	}
}
