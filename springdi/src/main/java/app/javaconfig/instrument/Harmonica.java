package app.javaconfig.instrument;

import org.springframework.stereotype.Component;

public class Harmonica implements Instrument {
	
	public Harmonica () {
		
	}

	public void play() {
		System.out.println("Pram pram praaam");
	}

	@Override
	public String toString() {
		return "harmonica";
	}
}
