package Game;

import java.io.*;
import interfacePackage.HaveDescription;

/**
 * A Item
 */
public abstract class Item implements Serializable,HaveDescription{

	
	private static final long serialVersionUID = 4846537447662735481L;
	private String 		name; //The name of the item

	/**
	 * A builder of Item class
	 * @param itemName  The item's name
	 */
	public Item(String itemName) {
		this.name = itemName;
	}
	
	/**
	 * 
	 * @return le nom de l'item
	 */
	public String getName(){
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
