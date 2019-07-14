package app.instrumental;

import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Instrumentalist implements Performer {

	public void perform() throws PerformerException {
		System.out.println("Playing " + song + " : ");
//		instrument.play();
	}

}
