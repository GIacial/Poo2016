package monster;

import java.util.List;

import Game.Item;
import useableItem.Item_Key;

public class QMonster_Alien extends Monster_Alien {


	private static final long serialVersionUID = -4635259554439729757L;

	public QMonster_Alien() {
		super();
	}

	@Override
	public List<Item> lootList() {
		List<Item>  loot = super.lootList();
		loot.add(new Item_Key());
		System.out.println(this.getName()+" laisse une Clé");
		
		//message
		System.out.println("Bip...Bip...");
		System.out.println("[Les Tortues] Vite reviens dans les égouts spliffers a été enlevé");
		
		return loot;
	}


	
	
	

}
