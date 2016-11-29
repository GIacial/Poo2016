package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import useableItem.Item_Honor;

public class Monster_Schredder extends Monster {



	private static final long serialVersionUID = -5474551312292110115L;

	/**
	 * Un constructeur de la classe
	 */
	public Monster_Schredder() {
		super("Schredder", 300, 40, 20);
	}

	@Override
	public void description() {
		System.out.println("Mamamia les mecs ça crains c'est Schredder ! ");

	}

	@Override
	public int lootXp() {
		return 125;
	}
	
	@Override
	public List<Item> lootList() {
		List<Item> loot = super.lootList();
		loot.add(new Item_Honor());
		System.out.println(this.getName()+" se rend");
		return loot;
	}

}

