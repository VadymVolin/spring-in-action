package app.stage;

public final class Stage {

	private Stage() {}
	
	private static class SingeltonStage {
		private final static Stage instance = new Stage();
	}
	
	public static Stage getInstance () {
		return SingeltonStage.instance;
	}
	
}
