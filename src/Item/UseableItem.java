package Item;

/**
 * An item which is useable
 */
public abstract class UseableItem  extends RecoverableItem{

	private static final long serialVersionUID = -360109109349746245L;

	
	
	/**
	 * Un constructeur d'item utilisable
	 * @param itemName Le nom de l'item
	 */
	public UseableItem(String itemName) {
		super(itemName);
	}

	
	/**
	 * A method which use an item
	 * @return  T if the object was used, else F
	 */
	abstract public boolean use(Object target);
}
