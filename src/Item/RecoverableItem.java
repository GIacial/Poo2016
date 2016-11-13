package Item;

import Game.Item;
import interfacePackage.Recoverable;

public  abstract class RecoverableItem extends Item implements Recoverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8846902233653983026L;


	public RecoverableItem(String itemName) {
		super(itemName);
	}


	@Override
	public Item take() {
		return this;
	}
}
