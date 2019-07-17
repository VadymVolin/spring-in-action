package app.instrumental;

import org.springframework.beans.factory.annotation.Configurable;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;

@Configurable("pianist")
public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;

	public void perform() throws PerformerException {
		System.out.println("Playing " + song + " : ");
		instrument.play();
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public String screamSong() {
		return song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
}
