package app.annotation.withoutbeans.instrument;

import app.annotation.myannotation.StringedInstrument;
import app.annotation.myannotation.Strummed;
import org.springframework.stereotype.Component;

//@Component
public class Guitar implements Instrument {
	
	public Guitar() {
		
	}

	public void play() {
		System.out.println("briing briing bring");
	}

	@Override
	public String toString() {
		return "guitar";
	}
}
