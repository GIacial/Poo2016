package npc;

import Game.Entity;
import exception.GameException_GameOver;

public abstract class Npc extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 203217179023916535L;


	public Npc(String name, int maxHeal, int attack, int defense) {
		super(name, maxHeal, attack, defense);
	}

	@Override
	public void takeDmg(int Dmg) throws GameException_GameOver {
		super.takeDmg(Dmg);
		System.out.println(this.getName() + " recoit " + Dmg + " dommages");
		if(!this.isAlive()){
			System.out.println("Vous avez tué " + this.getName());
		
		}
		
	}

	@Override
	public void takeHeal(int nbHeal) {
		super.takeHeal(nbHeal);
		System.out.println(this.getName() + " recoit " + nbHeal + " Hp");
	}
	
	public abstract void speak();


}
