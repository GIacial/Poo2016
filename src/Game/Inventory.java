package Game;

import java.util.*;
import Item.Equipement;
import Item.UseableItem;
import interfacePackage.Recoverable;

import java.io.*;


public class Inventory implements Serializable{

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = -3815028807156314828L;
	private List<Recoverable> itemList;	//faire list Recoverable
	
	/**
	 * A builder of Inventory Class
	 */
	public Inventory() {
		this.itemList= new ArrayList<Recoverable>();
	}

	/**
	 * Add object in the Inventory
	 * @param object  The item that you want add in the Inventory
	 */
	public void add(Recoverable object) {
		if(!this.itemList.contains(object) && object!=null){
			this.itemList.add(object);
		}
	}

	/**
	 * Remove a item which a name equal to itemName
	 * @param itemName  The name of the item that you want remove
	 * @return  The removed Item
	 */
	public Recoverable remove(String itemName) {
		Iterator<Recoverable> i = this.itemList.iterator();
		Recoverable r=null;
		while(i.hasNext() && r==null){
			Recoverable item= i.next();
			String name="";
			
			if(item instanceof Item){
				name=((Item)item).getName();
			}
			else{if(item instanceof Entity ){
				name=((Entity)item).getName();
				}
				else{
					System.err.println("Impossible de recup le nom du recuperable");
				}
			}
			
			if(name.equals(itemName)){
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
		Recoverable item = this.remove(itemName);
		if(item!=null){
			if(item instanceof UseableItem){
				if(!((UseableItem)item).use(target)){
					this.add(item);
				}
			}
			else{
				System.out.println(itemName+" n'est pas utilisable");
				this.add(item);
			}
		}
		else{
			System.out.println(itemName+" ne se trouve pas dans votre sac");
		}
	}

	/**
	 * @return  The list of all item in the inventory
	 */
	public List<Recoverable> getListItem() {
		return this.itemList;
	}



	/**
	 * @return  all the equipement in your inventory
	 */
	public List<Equipement> getListEquipement() {
		List<Equipement> r= new ArrayList<Equipement>();
		for(Recoverable i:this.itemList){
			if(i instanceof Equipement){
				r.add((Equipement)i);
			}
		}
		return r;
	}
}
