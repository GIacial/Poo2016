package Game;

import java.awt.*;

/**
 * A Monster
 */
public abstract class Monster extends Entity {

	/**
	 * serialVersionUID generated when implements Serializable
	 */
	private static final long serialVersionUID = 1709613719917260899L;

	/**
	 * A builder of the monster class
	 * @param name  the name of the new Monster
	 * @param maxHeal  The maximum life of the Monster
	 * @param attack  TODO (?) the attack of the new Monster
	 * @param defense  TODO (?) the defense of the new Monster
	 */
	public Monster(String name, int maxHeal, int attack, int defense) {
		super(name,maxHeal,attack,defense);
		throw new UnsupportedOperationException();
	}

	/**
	 * @return  The list of all item drops by the monster
	 */
	public abstract List lootList();

	/**
	 * @return  the amount of xp earn when the monster was defeat
	 */
	public abstract int lootXp();

	/**
	 * Define how the monsters reacts in a battle
	 * @param target  The possible target of the reaction
	 */
	public void chooseAttack(Hero target) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void takeDmg(int Dmg) {
		super.takeDmg(Dmg);
		System.out.println("Dommages infligés : " + Dmg);
		if(!this.isAlive()){
			System.out.println("Dommage reçu : " + Dmg);
			System.out.println("Vous avez tué" + this.getName());
			//supprimer le monstre de la pièce ? 
		
		}
	}
}
