package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import useableItem.Item_Potion;

public class Monster_Kankrelat extends Monster {

	@Override
	public List<Item> lootList() {
		List<Item> loot = super.lootList();
		if(Math.random() < 0.2){
			loot.add(new Item_Potion());
			System.out.println(this.getName()+" laisse une Potion");
		}
		return loot;
	}

	private static final long serialVersionUID = -5474551312292110115L;

	public Monster_Kankrelat() {
		super("Kankrelat", 25, 3, 4);
	}

	@Override
	public void description() {
		System.out.println("On dirait une sorte de pou sur pattes");

	}

	@Override
	public int lootXp() {
		return 5;
	}

}
