package npc;

import Game.Entity;
import Game.Item;
import exception.GameException_GameOver;

public abstract class Npc extends Entity {


	private static final long serialVersionUID = 203217179023916535L;

	/**
	 * Un constructeur de la classe
	 * @param name Le nom du npc
	 * @param maxHeal La vie max du NPC
	 * @param attack l'attaque du npc
	 * @param defense la defense du npc
	 */
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
	
	public  Item speak(){
		return null;
	}


}
