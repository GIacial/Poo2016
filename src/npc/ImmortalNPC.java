package npc;

import Game.Entity;

public abstract class ImmortalNPC extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332162407642388476L;

	public ImmortalNPC(String name, int maxHeal, int attack, int defense) {
		super(name, maxHeal, attack, defense);
	}

	@Override
	public void takeDmg(int Dmg) {
		System.out.println(this.getName()+" est immortel");
	}
	
	



}
