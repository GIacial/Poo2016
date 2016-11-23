package Item;

import Game.Item;
import interfacePackage.Recoverable;

public  abstract class RecoverableItem extends Item implements Recoverable {

	private static final long serialVersionUID = 8846902233653983026L;

	
	
	
	/**
	 * Un item recuperable
	 * @param itemName Le nom de l'item
	 */
	public RecoverableItem(String itemName) {
		super(itemName);
	}


	@Override
	public Recoverable take() {
		return this;
	}
}
