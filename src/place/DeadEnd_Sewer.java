package place;

import Game.Place;

public class DeadEnd_Sewer extends Place {


	private static final long serialVersionUID = -2405306234161724999L;

	public DeadEnd_Sewer() {
		super("�gouts impasse");
		//les item
	}

	@Override
	public void description() {
		System.out.println("Ce Couloir d'�gouts fini en cul de sac");
		super.description();
	}
	
	

}
