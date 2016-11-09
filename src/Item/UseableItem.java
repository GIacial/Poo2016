package Item;

import Game.Item;

/**
 * An item which is useable
 */
public abstract class UseableItem  extends Item{

	/**
	 * 
	 */
	private static final long serialVersionUID = -360109109349746245L;

	public UseableItem(String itemName) {
		super(itemName);
	}

	/**
	 * A method which use an item
	 * @return  T if the object was used, else F
	 */
	public boolean use(Object target) {
		throw new UnsupportedOperationException();
	}
}