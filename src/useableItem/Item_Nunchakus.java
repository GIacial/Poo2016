package useableItem;

import Item.UseableItem;
import exit.FinalDoor;
import exit.LockedExit;

public class Item_Nunchakus extends UseableItem {

	private static final long serialVersionUID = -5292529022192428882L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Nunchakus() {
		super("Nunchakus");
	}

	@Override
	public void description() {
		System.out.println("Ceci est un Nunchakus , elle possède une forme étrange à son bout");

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
