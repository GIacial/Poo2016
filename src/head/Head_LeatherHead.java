package head;

import Item.Head;

public class Head_LeatherHead extends Head {

	private static final long serialVersionUID = 6811771405819268860L;

	/**
	 * Un constructeur de la classe
	 */
	public Head_LeatherHead() {
		super("Casque_en_cuir", 1, 0, 3);
	}

	@Override
	public void description() {
		System.out.println("Un casque en cuir");

	}

}
