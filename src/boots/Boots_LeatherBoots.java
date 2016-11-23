package boots;

import Item.Boots;

public class Boots_LeatherBoots extends Boots {

	private static final long serialVersionUID = -8047518059769414935L;

	/**
	 * Un constructeur de la classe
	 */
	public Boots_LeatherBoots() {
		super("Bottes_en_cuir", 1, 0, 0);
	}

	@Override
	public void description() {
		System.out.println("Des bottes en cuir");
		
	}

}
