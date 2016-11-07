package Game;

/**
 * A Hero
 */
public class Hero extends Entity {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -8480399582238471911L;

	private EquipementSet equipement;
	
	private Inventory inventory;

	/**
	 * A builder of Hero Class
	 * @param name  The name of the new Hero
	 */
	public Hero(String name) {
		super(name,0,0,0,0);	//TODO 
		throw new UnsupportedOperationException();
	}

	/**
	 * Equip the equipement called as nameEquip
	 * @param nameEquip  The name of the equipement that you want equip
	 */
	public void equip(String nameEquip) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add the item to the hero's inventory
	 * @param item  The item that the hero want add to his inventory
	 */
	public void takeItem(Item item) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Throw a item from your inventory
	 * @param nameItem  The name of the item that you want throw
	 * @return  the item that you throw
	 */
	public Item throwItem(String nameItem) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unequip the equipement'zone that you choose
	 * @param name  the name of the equipement'zone that you want unequip
	 */
	public void unequip(String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Use a item from your inventory
	 * @param nameItem  the name of the item that you want use
	 */
	public void useItem(String nameItem) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Print all the item of the type typeItem in your inventory
	 * @param typeItem  the item's type that you want print on the screen
	 */
	public void lookInventory(String typeItem) {
		throw new UnsupportedOperationException();
	}
}
