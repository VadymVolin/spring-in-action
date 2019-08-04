package app.javaconfig.instrument;

import app.annotation.myannotation.StringedInstrument;

@StringedInstrument
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
