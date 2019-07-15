package app.instrumental;

import java.util.Collection;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;

public class OneManBand implements Performer {
	
	private Collection<Instrument> instruments;
	
	public OneManBand() {
		
	}
	
	public void setInstruments (Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	public void perform() throws PerformerException {
		for (Instrument instrument : instruments) {
			instrument.play();
		}
	}

}
