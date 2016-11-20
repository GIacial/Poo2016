package furniture;

import Item.Furniture;

public class Furniture_Fridge extends Furniture {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7493017566262090385L;

	public Furniture_Fridge() {
		super("Frigo");
	}

	@Override
	public void description() {
		System.out.println("Ce frigo n'est plus fonctionnel depuis longtemps");

	}

}
