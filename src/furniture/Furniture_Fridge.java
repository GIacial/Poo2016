package furniture;

import Item.Furniture;

/**
 * 
 * Un frigo décoratif
 *
 */
public class Furniture_Fridge extends Furniture {

	private static final long serialVersionUID = -7493017566262090385L;

	/**
	 * Un constructeur de frigo decoratif
	 */
	public Furniture_Fridge() {
		super("Frigo");
	}

	@Override
	public void description() {
		System.out.println("Ce frigo n'est plus fonctionnel depuis longtemps");

	}

}
