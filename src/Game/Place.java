package Game;

import java.util.*;
import interfacePackage.HaveDescription;
import interfacePackage.Recoverable;

import java.io.*;

public abstract class Place implements Serializable,HaveDescription {

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
	public void setLink(String name, Exit exit) {
		if(this.exit.containsKey(name) || this.exit.containsValue(exit) || exit==null){
			System.err.println(name+" ou "+ exit +" est deja affecté ou exit vaut null");
		}
		else{
			this.exit.put(name, exit);
		}
		
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
	 * @return T if target is find else F
	 */
	public boolean getDescriptionItem(String itemName) {
		boolean r=false;
		for(Item i : this.listItem){
			if(i.getName().equals(itemName)){
				i.description();
				r=true;
				break;
			}
		}
		return r;
	}
	
	public boolean getDescriptionEntity(String entityName,boolean analyse){
		boolean r=false;
		for(Entity e : this.listEntity){
			if(e.getName().equals(entityName)){
				r=true;
				if(analyse){
					e.entityDescription();
				}
				else{
					e.description();
				}
				break;
			}
		}
		return r;
	}

	/**
	 * print the list of all item in this place
	 */
	public void listItem() {
		if(this.listItem.isEmpty()){
			System.out.println("Le lieu est vide");
		}
		else{
			for(Item i:this.listItem){
				System.out.println(i);
			}
		}
		
	}

	/**
	 * print the description of the exit
	 * @param exitName  the name of the exit
	 * @return T if target is find else F
	 */
	public boolean exitDescription(String exitName) {
		boolean r=false;
		if(this.exit.containsKey(exitName)){
			this.exit.get(exitName).description();
			r=true;
		}
		return r;
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
				break;
			}
		}
		return findMonster;
	}

	/**
	 * Hero attack a monster and all monster attack the hero
	 * @param hero  the hero
	 * @param target  the target's name
	 */
	public void fight(Hero hero, String target,boolean actifHero) {
		boolean attackOk=false;
		if(actifHero){
			Entity targetEntity=this.removeEntity(target);
			if(targetEntity!=null){
				hero.attack(targetEntity);
				attackOk=true;
				if(targetEntity.isAlive()){
					this.addEntity(targetEntity);
				}
				else{
					if(targetEntity instanceof Monster){
						List<Item> loot=((Monster)targetEntity).lootList();
						for(Item i:loot){
							this.addItem(i);
						}
						hero.increaseXp(((Monster)targetEntity).lootXp());
						
					}
					
				}
			}
			else{
				System.out.println(target+" n'a pas été trouvé");
			}
		}
		
		if((actifHero && attackOk)|| !actifHero){//si le hero n'attaque pas ou qu'il attaque une cible correct

			for(Entity entity:this.listEntity){
				if(entity instanceof Monster){
					Monster monster=(Monster)entity;

					monster.chooseAttack(hero);
				}
			}
		}
	}

	/**
	 * Add a entity in this place
	 * @param entity  the entity add in this place
	 */
	public void addEntity(Entity entity) {
		if(!this.listEntity.contains(entity) && entity!=null){
			this.listEntity.add(entity);
		}
	}

	/**
	 * Remove a entity in this place 
	 * @param entityName  the entity's name
	 * @return  the entity removed
	 */
	public Entity removeEntity(String entityName) {
		Iterator<Entity> e = this.listEntity.iterator();
		Entity r=null;
		while(e.hasNext() && r==null){
			Entity entity=e.next();
			if(entity.getName().equals(entityName)){
				r=entity;
				e.remove();
			}
		}
		return r;
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public void description() {
		if(this.getNbItem()>0){
			System.out.println("Ce lieu contient de nombreux object");
		}
		if(this.getNbEntity()>0){
			System.out.println("Vous voyez des ombres bouger");
		}
		if(this.getNbExit()>0){
			System.out.println("Il y a "+this.getNbExit()+" sortie");
		}

	}
	
	
	public int getNbItem(){
		return this.listItem.size();
	}
	
	public int getNbEntity(){
		return this.listEntity.size();
	}
	
	public int getNbExit(){
		return this.exit.size();
	}

	/**
	 * @param name  the object's name
	 * @return  the item that you have take
	 */
	public Recoverable takeSomething(String name){
		Recoverable i=null;
		Item item=this.removeItem(name);
		if(item==null){
			Entity e=this.removeEntity(name);
			if(e!=null){//verif entite
				if(e instanceof Recoverable){
					i=((Recoverable)e).take();
				}
				else{
					this.addEntity(e);//on remets l'entity qui ne correspond pas
				}
			}
		}
		else{//verif item
			if(item instanceof Recoverable){
				i=((Recoverable)item).take();
			}
			else{
				this.addItem(item);//on remets l'item qui ne correspond pas
				
			}
		}
		if(i==null){
			System.out.println(name+" n'est pas rammasable");
		}
		
		return i;
	}
	
	public Exit getExit(String exitName){
		Exit e=null;
		if(this.exit.containsKey(exitName)){
			e=this.exit.get(exitName);
		}
		return e;
	}
	

}
