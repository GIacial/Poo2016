package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import chest.Chest_LeatherChest;
import trouser.Trouser_LeatherTrouser;
import useableItem.Item_Potion;

public class Monster_Alien extends Monster {

	private static final long serialVersionUID = -1412214908212994526L;

	/**
	 * Un constructeur de la classe
	 */
	public Monster_Alien() {
		super("Alien", 50, 7, 5);
	}

	@Override
	public void description() {
		System.out.println("Un alien gluant !");

	}

	@Override
	public int lootXp() {
		return 10;
	}
	
	@Override
	public List<Item> lootList() {
		List<Item> loot = super.lootList();
		if(Math.random() < 0.3){
			loot.add(new Item_Potion());
			System.out.println(this.getName()+" laisse une Potion");
		}
		if(Math.random() < 0.2){
			loot.add(new Trouser_LeatherTrouser());
			System.out.println(this.getName()+" laisse un pantalon en cuir");
		}
		if(Math.random() < 0.25){
			loot.add(new Chest_LeatherChest());
			System.out.println(this.getName()+" laisse un plastron en cuir");
		}
		return loot;
	}
}
