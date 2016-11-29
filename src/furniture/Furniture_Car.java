package furniture;

import Item.Furniture;

public class Furniture_Car extends Furniture {

	private static final long serialVersionUID = -373069368014904179L;

	public Furniture_Car() {
		super("Voiture");
	}

	@Override
	public void description() {
		System.out.println("Une voiture ou plutôt une épave de voiture");

	}

}
