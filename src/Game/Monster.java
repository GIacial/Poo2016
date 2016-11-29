package Game;

import java.util.ArrayList;
import java.util.List;

import exception.GameException_GameOver;

/**
 * A Monster
 */
public abstract class Monster extends Entity {


	private static final long serialVersionUID = 1709613719917260899L;

	/**
	 * A builder of the monster class
	 * @param name  the name of the new Monster
	 * @param maxHeal  The maximum life of the Monster
	 * @param attack   the attack of the new Monster
	 * @param defense   the defense of the new Monster
	 */
	public Monster(String name, int maxHeal, int attack, int defense) {
		super(name, maxHeal, attack, defense);
	}

	/**
	 * @return  The list of all item drops by the monster
	 */
	public List<Item> lootList(){
		return new ArrayList<Item>();
	}

	/**
	 * @return  the amount of xp earn when the monster was defeat
	 */
	public abstract int lootXp();

	/**
	 * Define how the monsters reacts in a battle
	 * @param target  The possible target of the reaction
	 * @throws GameException_GameOver if the hero died
	 */
	public void chooseAttack(Hero target) throws GameException_GameOver {
		System.out.println(this.getName() + " vous attaque");
		this.attack(target);
	}
	
	@Override
	public void takeDmg(int Dmg) throws GameException_GameOver {
		super.takeDmg(Dmg);
		System.out.println(this.getName() + " recoit " + Dmg + " dommages");
		if(!this.isAlive()){
			System.out.println("Cowabunga ! Vous avez tué " + this.getName());
		
		}
	}

	@Override
	public void entityDescription() {
		super.entityDescription();
		System.out.println("Il est certain que c'est un monstre");
	}

	
}
