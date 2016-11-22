package useableItem;

import Game.Entity;
import Item.UseableItem;

public class Item_Potion extends UseableItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5505654106820976445L;

	public Item_Potion() {
		super("Potion");
	}

	@Override
	public void description() {
		System.out.println("Une fiole contenant un liquide rose pâle");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof Entity){
			Entity e = (Entity)target;
			e.takeHeal(50);
			use = true;
			System.out.println("La potion soigne "+e.getName());
		}
		else{
			System.out.println("Impossible d'utiliser la Potion sur cette cible");
		}
		return use;
	}

}
