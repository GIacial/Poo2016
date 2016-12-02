package useableItem;

import Game.Entity;
import Item.UseableItem;

public class Item_BigPotion extends UseableItem {


	private static final long serialVersionUID = -6496697546594154307L;

	public Item_BigPotion() {
		super("Remede_special");
	}

	@Override
	public void description() {
		super.description();
		System.out.println("Ca n'a pas l'air bon mais c'est efficace");

	}

	@Override
	public boolean use(Object target) {
		boolean use = false;
		if(target instanceof Entity){
			Entity e = (Entity)target;
			e.takeHeal(150);
			use = true;
			System.out.println("La potion soigne " + e.getName());
		}
		else{
			System.out.println("Impossible d'utiliser le remède sur cette cible");
		}
		return use;
	}

}
