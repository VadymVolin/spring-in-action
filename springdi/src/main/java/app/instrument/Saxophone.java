package app.instrument;

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
