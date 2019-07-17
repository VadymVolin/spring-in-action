package app.instrumental;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;

public abstract class AbstractInstrumentalist implements Performer {

	private String song;
	private Instrument instrument;

	public void perform() throws PerformerException {
		System.out.println("Playing " + song + " : ");
		getInstrument().play();
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

	public abstract Instrument getInstrument();

}
