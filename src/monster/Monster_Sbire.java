package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import useableItem.Item_Potion;
import weapon.Weapon_IronSword;

public class Monster_Sbire extends Monster {



	private static final long serialVersionUID = -5474551312292110115L;

	/**
	 * Un constructeur de la classe
	 */
	public Monster_Sbire() {
		super("Sbire", 100, 10, 20);
	}

	@Override
	public void description() {
		System.out.println("Un sbire de Schredder !");

	}

	@Override
	public int lootXp() {
		return 30;
	}
	
	@Override
	public List<Item> lootList() {
		List<Item> loot = super.lootList();
		if(Math.random() < 0.9){
			loot.add(new Item_Potion());
			System.out.println(this.getName()+" laisse une Potion");
		}
		if(Math.random() < 0.1){
			loot.add(new Weapon_IronSword());
			System.out.println(this.getName()+" laisse tomber une épée en fer");
		}
		return loot;
	}
}


