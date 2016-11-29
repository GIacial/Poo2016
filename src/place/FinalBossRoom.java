package place;

import Game.Place;

public class FinalBossRoom extends Place {


	private static final long serialVersionUID = -9206927899811765324L;

	public FinalBossRoom() {
		super("Salle du boss final");
	}

	@Override
	public void description() {
		System.out.println("Il vous attendez");
		super.description();
	}
	
	

}
