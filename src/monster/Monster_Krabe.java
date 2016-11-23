package monster;

import java.util.List;

import Game.Item;
import Game.Monster;
import useableItem.Item_Potion;

public class Monster_Krabe extends Monster {

	private static final long serialVersionUID = 5653403462339012651L;

	/**
	 * Un constructeur de la classe
	 */
	public Monster_Krabe() {
		super("Krabe", 80, 8, 10);
	}


	@Override
	public void description() {
		System.out.println("Un crabe géant rouge");

	}

	@Override
	public int lootXp() {
		return 12;
	}
	
	@Override
	public List<Item> lootList() {
		List<Item> r = super.lootList();
		if(Math.random() < 0.50){
			r.add(new Item_Potion());
			System.out.println(this.getName() + " laisse une Potion");
		}
		return r;
	}

}
