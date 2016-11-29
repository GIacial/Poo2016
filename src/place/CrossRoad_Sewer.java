package place;

import Game.Place;

public class CrossRoad_Sewer extends Place {


	private static final long serialVersionUID = 2814370318508051540L;

	public CrossRoad_Sewer() {
		super("Carrefour");
		//les item
		
	}
	
	@Override
	public void description() {
		System.out.println("Les égouts partent dans plusieurs directions");
		super.description();
	}

}
