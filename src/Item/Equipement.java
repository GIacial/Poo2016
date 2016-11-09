package Item;

import Game.Item;


public abstract class Equipement extends Item {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = 2631997706440494533L;

	private int defenseBonus;
	private int attackBonus;
	private int healthBonus;

	/**
	 * A builder of Equipement class
	 * @param name  The name of the Equipement
	 */
	public Equipement(String name ,int defB, int atkB,int healB) {
		super(name);
		this.attackBonus=atkB;
		this.defenseBonus=defB;
		this.healthBonus=healB;
	}

	public int getDefenseBonus() {
		return this.defenseBonus;
	}

	public int getAttackBonus() {
		return this.attackBonus;
	}

	public int getHealthBonus() {
		return this.healthBonus;
	}
}
