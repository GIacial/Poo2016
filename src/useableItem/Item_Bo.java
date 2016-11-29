package useableItem;

import Item.UseableItem;
import exit.FinalDoor;

public class Item_Bo extends UseableItem {

	private static final long serialVersionUID = -7444926046360064579L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Bo() {
		super("Bo");
	}

	@Override
	public void description() {
		System.out.println("Ceci est un Bo , elle possède une forme étrange à son bout");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof FinalDoor){
			FinalDoor door = (FinalDoor)target;
			use = door.open(this);		
		}
		else{
			System.out.println("Impossible d'utiliser cette arme sur cette porte");
		}
		return use;
	}

}