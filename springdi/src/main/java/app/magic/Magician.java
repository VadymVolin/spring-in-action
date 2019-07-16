package app.magic;

import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Magician implements Performer {
	
	private String magicWords;
	private MagicBox magicBox;

	public Magician () {}

	public void perform() throws PerformerException {
		System.out.println(magicWords);
		System.out.println("The magic box contains...");
		System.out.println(magicBox.getContents());
	}
	
	public void setMagicBox(MagicBox magicBox) {
		this.magicBox = magicBox;
	}
	
	public void setMagicWords(String magicWords) {
		this.magicWords = magicWords;
	}

}
