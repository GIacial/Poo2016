package useableItem;

import Item.RecoverableItem;

public class Item_Honor extends RecoverableItem {

	private static final long serialVersionUID = -8720422622528392295L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Honor() {
		super("Cle");
	}

	@Override
	public void description() {
		System.out.println("Ceci est l'honneur de Schredder");

	}


}