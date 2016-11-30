package useableItem;

import Item.UseableItem;
import exit.FinalDoor;

public class Item_Sais extends UseableItem {

	private static final long serialVersionUID = 5150844387820867203L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Sais() {
		super("Sais");
	}

	@Override
	public void description() {
		super.description();
		System.out.println("Ceci est un Sais , elle possède une forme étrange à son bout");

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

