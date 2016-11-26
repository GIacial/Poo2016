package useableItem;

import Item.UseableItem;
import exit.LockedExit;

public class Item_Key extends UseableItem {

	private static final long serialVersionUID = -6435067717372497868L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Key() {
		super("Cle");
	}

	@Override
	public void description() {
		System.out.println("Ceci est une clé , elle sert surement à ouvrir quelque-chose");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof LockedExit){
			LockedExit door = (LockedExit)target;
			use = door.open(this);		
		}
		else{
			System.out.println("Impossible d'utiliser la clé sur cette cible");
		}
		return use;
	}

}
