package chest;

import Item.Chest;

public class Chest_LeatherChest extends Chest {

	private static final long serialVersionUID = 5669406930972865849L;

	/**
	 * Un constructeur de la classe
	 */
	public Chest_LeatherChest() {
		super("Plastron_en_cuir", 3, 0, 5);
	}

	@Override
	public void description() {
		System.out.println("Un plastron en cuir");

	}

}
