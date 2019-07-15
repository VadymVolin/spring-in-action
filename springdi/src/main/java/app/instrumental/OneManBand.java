package app.instrumental;

import java.util.Map;

import app.instrument.Instrument;
import app.performer.Performer;
import app.performer.exception.PerformerException;

public class OneManBand implements Performer {
	
	private Map<String, Instrument> instruments;
	
	public OneManBand() {
		
	}
	
	public void setInstruments (Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	public void perform() throws PerformerException {
		for (String instrName : instruments.keySet()) {
			System.out.print(instrName + " : ");
			Instrument instrument = instruments.get(instrName);
			instrument.play();
		}
	}

}
