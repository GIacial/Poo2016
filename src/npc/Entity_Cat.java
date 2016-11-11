package npc;

import Game.Entity;
import Game.Item;
import Item.Item_Cat;
import interfacePackage.Recoverable;

public class Entity_Cat extends Entity implements Recoverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6925215999645074550L;

	public Entity_Cat() {
		super("chat", 5, 2, 0);
	}

	@Override
	public void description() {
		System.out.println("Un chat classique rien de plus");

	}

	@Override
	public Item take() {
		return new Item_Cat();
	}

}
