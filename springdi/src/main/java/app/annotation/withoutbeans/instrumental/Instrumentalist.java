package app.annotation.withoutbeans.instrumental;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component("eddie")
public class Instrumentalist implements Performer {

	@Value("eddie")
	private String name;
	@Value("Day in hell")
	private String song;
	@Inject
	@Named("instrument")
	private Instrument instrument;

	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrumentalist(String name, String song, Instrument instrument) {
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}

	public Instrumentalist() {
		System.out.println("create eddie");
	}

	public void perform() throws PerformerException {
		System.out.println("Playing " + song + " : ");
		instrument.play();
	}

	@Override
	public String toString() {
		return (name == null ? "" : name) + " singe " + song + " -- " + instrument.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
