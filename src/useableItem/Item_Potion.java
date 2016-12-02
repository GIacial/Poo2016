package useableItem;

import Game.Entity;
import Item.UseableItem;

public class Item_Potion extends UseableItem {


	private static final long serialVersionUID = 5505654106820976445L;

	/**
	 * Un constructeur de la classe
	 */
	public Item_Potion() {
		super("Soda");
	}

	@Override
	public void description() {
		super.description();
		System.out.println("Une cannette de soda");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof Entity){
			Entity e = (Entity)target;
			e.takeHeal(50);
			use = true;
			System.out.println("Le " + this.getName() + " soigne "+e.getName());
		}
		else{
			System.out.println("Impossible d'utiliser le soda sur cette cible");
		}
		return use;
	}

}
