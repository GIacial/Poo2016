package place;

import Game.Place;

public class CrossRoad_Street extends Place {

	private static final long serialVersionUID = 5459972386811262242L;

	public CrossRoad_Street() {
		super("Carrefour");
		//les item a mettre
	}

	@Override
	public void description() {
		System.out.println("La rue part dans plusieurs directions");
		super.description();
	}
	
	

}
