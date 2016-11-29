package place;

import Game.Place;

public class DeadEnd_Street extends Place {


	private static final long serialVersionUID = -3281795312858195131L;

	public DeadEnd_Street() {
		super("Rue impasse");
		//les truc a mettre dedans
	}

	@Override
	public void description() {
		System.out.println("Cette rue est un cul de sac");
		super.description();
	}
	
	

}
