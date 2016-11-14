package Game;

import java.util.ArrayList;
import java.util.List;

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
		super(name,30,5,5);	
		this.equipement= new EquipementSet(this);
		this.inventory= new Inventory();
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
		this.inventory.add(item);
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
		List<Item> l= new ArrayList<Item>();
		switch(typeItem.toLowerCase()){
			case "equipement":l.addAll(this.inventory.getListEquipement());
				break;
			default:l=this.inventory.getListItem();
				break;
		}
		if(l.isEmpty()){
			System.out.println("Votre sac ne contient pas "+typeItem);
		}
		for(Item i: l){
			System.out.println(i.getName());
		}
	}

	@Override
	public void description() {
		System.out.println("C'est moi");
		//this.entityDescription();
		
	}

	@Override
	public int getAttack() {
		return super.getAttack()+this.equipement.getDmgWeapon();
	}
	
	
}
