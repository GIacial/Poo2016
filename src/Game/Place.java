package Game;

import java.io.Serializable;
import java.util.*;
import java.io.*;

public abstract class Place implements Serializable {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -105354579675980999L;
	private Map<String,Exit> exit;
	private List<Entity> listEntity;
	private List<Item> listItem;
	/**
	 * the place's name
	 */
	private String name;

	/**
	 * A builder of Place class
	 * @param name  the name of the new Place
	 */
	public Place(String name) {
		this.name=name;
		this.exit= new HashMap<String,Exit>();
		this.listEntity= new ArrayList<Entity>();
		this.listItem= new ArrayList<Item>();
	}

	/**
	 * Create a exit for this place TODO passer une Exit en param ?
	 * @param name  the name of the new exit
	 * @param nextPlace  the place where you're going when you're existing the place
	 */
	public void setLink(String name, Place nextPlace) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  all the name of exit of this place
	 */
	public Set<String> getNameExit() {
		return this.exit.keySet();
	}

	/**
	 * @param exitName  the name of the exit
	 * @return  the place where you go when you cross the exit
	 */
	public Place getNextPlace(String exitName) {
		Place next=null;
		if(this.exit.containsKey(exitName)){
			next=this.exit.get(exitName).crossing();
		}
		return next;
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
		for(Item i:this.listItem){
			System.out.println(i);
		}
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
		List<String> r= new ArrayList<String>();
		for(Entity e:this.listEntity){
			r.add(e.getName());
		}
		return r;
	}

	/**
	 * Put a item in this place
	 * @param item  the item that you want put here
	 */
	public void addItem(Item item) {
		if(item!=null){
			this.listItem.add(item);
		}
		else{
			System.err.println("L'item vaut null");
		}
	}

	/**
	 * Remove a item from this place
	 * @param itemName  the item's name
	 * @return  the item removed
	 */
	public Item removeItem(String itemName) {
		Item r=null;
		Iterator<Item> i=this.listItem.iterator();
		while(i.hasNext() && r==null){
			Item item=i.next();
			if(item.getName().equals(itemName)){
				r=item;
				i.remove();
			}
		}
		return r;
	}

	/**
	 * @return  Return true if this place contains a monster else false
	 */
	public boolean haveMonster() {
		boolean findMonster=false;
		for(Entity e:this.listEntity){
			if(e instanceof Monster){
				findMonster=true;
			}
		}
		return findMonster;
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
	 * TODO (?) demande accord lucille 
	 * Add a entity in this place
	 * @param entity  the entity add in this place
	 */
	public void addEntity(Entity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a entity in this place 
	 * TODO (?) demande accord lucille
	 * @param entityName  the entity's name
	 * @return  the entity removed
	 */
	public Entity removeEntity(String entityName) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 
	 */
	public String getName(){
		return this.name;
	}
	

}
