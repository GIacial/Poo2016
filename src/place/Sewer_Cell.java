package place;

import Game.Place;

public class Sewer_Cell extends Place{

	private static final long serialVersionUID = 1430124047145140991L;

	public Sewer_Cell() {
		super("Prison");
		//ajout des object
	}

	@Override
	public void description() {
		System.out.println("Spliffers est attaché au mur");
		super.description();
	}


	

}
