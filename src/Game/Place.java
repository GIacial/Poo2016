package Game;

import java.util.*;

public abstract class Place {

	private Map<String,Exit> exit;
	private List<Entity> listEntity;
	private List<Item> listItem;
	/**
	 * the name of the place
	 */
	private String name;

	/**
	 * A builder of Place class
	 * @param name  the name of the new Place
	 */
	public Place(String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Create a exit for this place
	 * @param name  the name of the new exit
	 * @param nextPlace  the place where you go when you crossing the exit
	 * @param typeExit  the name of the type of the new exit TODO (?) demande accord lucille
	 */
	public void setLink(String name, Place nextPlace, String typeExit) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  all the name of exit of this place
	 */
	public List<String> getNameExit() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param exitName  the name of the exit
	 * @return  the place where you go when you cross the exit
	 */
	public Place getNextPlace(String exitName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * print the description of the item
	 * @param itemName  the name of the item that you want look
	 */
	public void getDescriptionItem(int itemName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * print the list of all item in this place
	 */
	public void listItem() {
		throw new UnsupportedOperationException();
	}

	/**
	 * print the description of the exit
	 * @param exitName  the name of the exit
	 */
	public void exitDescription(String exitName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  all name of entities in this place
	 */
	public List<String> getNameEntites() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Put a item in this place
	 * @param item  the item that you want put here
	 */
	public void addItem(Item item) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a item from this place
	 * @param itemName  the item's name
	 * @return  the item removed
	 */
	public Item removeItem(String itemName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  Return true if this place contains a monster else false
	 */
	public boolean haveMonster() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Hero attack a monster and all monster attack the hero
	 * @param hero  the hero
	 * @param target  the target's name
	 */
	public void fight(Hero hero, String target) {
		throw new UnsupportedOperationException();
	}

	/**
	 * TODO (?) demande accord lucille Add a entity in this place
	 * @param entity  the entity add in this place
	 */
	public void addEntity(Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a entity in this place TODO (?) demande accord lucille
	 * @param entityName  the entity's name
	 * @return  the entity removed
	 */
	public Entity removeEntity(String entityName) {
		throw new UnsupportedOperationException();
	}
}
