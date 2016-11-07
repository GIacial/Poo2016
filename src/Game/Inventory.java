package Game;

import java.io.Serializable;
import java.util.*;
import java.io.*;

public class Inventory implements Serializable{

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3815028807156314828L;
	private List<Item> itemList;

	/**
	 * Add object in the Inventory
	 * @param object  The item that you want add in the Inventory
	 */
	public void add(Item object) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a item which a name equal to itemName
	 * @param itemName  The name of the item that you want remove
	 * @return  The removed Item
	 */
	public Item remove(String itemName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Use a item which a name equals to itemName
	 * @param itemName  The name of the item that you want use
	 */
	public void use(String itemName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  The list of all item in the inventory
	 */
	public List<Item> getListItem() {
		throw new UnsupportedOperationException();
	}

	/**
	 * A builder of Inventory Class
	 */
	public Inventory() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  all the equipement in your inventory
	 */
	public List<Equipement> getListEquipement() {
		throw new UnsupportedOperationException();
	}
}
