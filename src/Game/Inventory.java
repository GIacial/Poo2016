package Game;

import java.util.*;
import Item.Equipement;
import java.io.*;


public class Inventory implements Serializable{

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3815028807156314828L;
	private List<Item> itemList;
	
	/**
	 * A builder of Inventory Class
	 */
	public Inventory() {
		this.itemList= new ArrayList<Item>();
	}

	/**
	 * Add object in the Inventory
	 * @param object  The item that you want add in the Inventory
	 */
	public void add(Item object) {
		if(!this.itemList.contains(object) && object!=null){
			this.itemList.add(object);
		}
	}

	/**
	 * Remove a item which a name equal to itemName
	 * @param itemName  The name of the item that you want remove
	 * @return  The removed Item
	 */
	public Item remove(String itemName) {
		Iterator<Item> i = this.itemList.iterator();
		Item r=null;
		while(i.hasNext() && r==null){
			Item item= i.next();
			if(item.getName().equals(itemName)){
				r=item;
				i.remove();
			}
		}
				
		return r;
	}

	/**
	 * Use a item which a name equals to itemName
	 * @param itemName  The name of the item that you want use
	 * 
	 */
	public void use(String itemName,Object target) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  The list of all item in the inventory
	 */
	public List<Item> getListItem() {
		return this.itemList;
	}



	/**
	 * @return  all the equipement in your inventory
	 */
	public List<Equipement> getListEquipement() {
		List<Equipement> r= new ArrayList<Equipement>();
		for(Item i:this.itemList){
			if(i instanceof Equipement){
				r.add((Equipement)i);
			}
		}
		return r;
	}
}
