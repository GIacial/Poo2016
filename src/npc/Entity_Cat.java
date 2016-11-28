package npc;

import Game.Item;
import interfacePackage.Recoverable;

public class Entity_Cat extends Npc implements Recoverable {


	private static final long serialVersionUID = -6925215999645074550L;

	/**
	 * Un constructeur de la classe
	 */
	public Entity_Cat() {
		super("chat", 5, 2, 0);
	}

	@Override
	public void description() {
		System.out.println("Un chat classique rien de plus");

	}

	@Override
	public Recoverable take() {
		return this;
	}

	@Override
	public Item speak() {
		System.out.println("[" + this.getName() + "] " + "Miaou!!");
		return super.speak();
		
	}



}
