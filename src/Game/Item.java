package Game;

import java.io.*;

import interfacePackage.HaveDescription;

/**
 * A Item
 */
public abstract class Item implements Serializable,HaveDescription{
	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = 4846537447662735481L;
	/**
	 * The name of the Item
	 */
	private String name;

	/**
	 * A builder of Item class
	 */
	public Item() {
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
