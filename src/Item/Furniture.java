package Item;

import Game.Item;

/**
 * Decorative item
 */
public abstract class Furniture extends Item {

	private static final long serialVersionUID = 7995472418621093645L;

	public Furniture(String itemName) {
		super(itemName);
	}
}
