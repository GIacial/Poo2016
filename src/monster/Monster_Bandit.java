package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import useableItem.Item_Potion;
import weapon.Weapon_BasicSword;

public class Monster_Bandit extends Monster {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -513533974200976404L;

	/**
	 * Un constructeur de la classe
	 */
	public Monster_Bandit() {
		super("Bandit", 25, 3, 4);
	}

	@Override
	public void description() {
		System.out.println("Un bandit masqué, habillé en noir");

	}

	@Override
	public int lootXp() {
		return 5;
	}
	
	@Override
	public List<Item> lootList() {
		List<Item> loot = super.lootList();
		if(Math.random() < 0.5){
			loot.add(new Weapon_BasicSword());
			System.out.println(this.getName() + " laisse une épée basic");
		}
		if(Math.random() < 0.6){
			loot.add(new Item_Potion());
			System.out.println(this.getName() + " laisse une potion");
		}
		return loot;
	}

}
